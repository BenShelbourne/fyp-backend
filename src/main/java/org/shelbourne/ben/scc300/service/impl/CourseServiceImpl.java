package org.shelbourne.ben.scc300.service.impl;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.shelbourne.ben.scc300.generated.lancaster.module.Item;
import org.shelbourne.ben.scc300.generated.lancaster.module.Module;
import org.shelbourne.ben.scc300.generated.lancaster.module.Section;
import org.shelbourne.ben.scc300.generated.model.AssessmentStatus;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.shelbourne.ben.scc300.generated.model.Course;
import org.shelbourne.ben.scc300.generated.model.CourseworkItem;
import org.shelbourne.ben.scc300.repository.CourseworkItemRepository;
import org.shelbourne.ben.scc300.repository.model.CalendarEventEntity;
import org.shelbourne.ben.scc300.repository.model.CourseworkItemEntity;
import org.shelbourne.ben.scc300.service.AssessmentTrackingService;
import org.shelbourne.ben.scc300.service.AuthenticationFacade;
import org.shelbourne.ben.scc300.service.CourseService;
import org.shelbourne.ben.scc300.service.LancasterUniService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseworkItemRepository courseworkItemRepository;
    private final AssessmentTrackingService assessmentTrackingService;
    private final LancasterUniService lancasterUniService;
    private final AuthenticationFacade authentication;
    private final ModelMapper modelMapper;

    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public List<Course> getCoursesForStudentId() {
        Module module = lancasterUniService.getModule();
        Section section = getCourseSectionFromModule(module);
        return getCoursesFromSection(section);
    }

    @Override
    public Course getCourse(String courseId) {
        return getCoursesForStudentId().stream().filter(c -> c.getLusiCourseId().equals(courseId)).findAny().orElseThrow(() -> new IllegalArgumentException("Unable to find course Id " + courseId));
    }

    @Override
    public Course getCourseForLusiWorkId(String lusiWorkId) {
        CourseworkItemEntity cie = courseworkItemRepository.findByLusiWorkId(lusiWorkId);
        if (cie == null) {
            throw new IllegalArgumentException(String.format("Unable to find lusiWorkId for %s", lusiWorkId));
        }
        return getCourse(cie.getLusiCourseId());
    }

    private Section getCourseSectionFromModule(Module module) {
        return module.getSections().stream().filter(s -> s.getName().startsWith("Your Course Modules for")).findFirst().orElseThrow(() -> new RuntimeException("No courses found!"));
    }

    private List<Course> getCoursesFromSection(Section section) {
        return section.getItems().stream().map(i -> getCourseFromItem(i)).collect(Collectors.toList());
    }

    private Course getCourseFromItem(Item item) {
        List<CourseworkItem> courseworkItems = new ArrayList<>();
        item.getAssessments().forEach(a -> courseworkItems.addAll(getCourseworkItemsForCourse(a, item)));
        Course course = new Course()
            .lusiCourseId(item.getLusiCourseId())
            .lusiYearId(item.getLusiYearId())
            .lusiCohortId("" + item.getLusiCohortId())
            .name(item.getName())
            .startDate(LocalDateTime.parse(item.getCourseInfo().getStartDate()))
            .endDate(LocalDateTime.parse(item.getCourseInfo().getEndDate()))
            .coursework(courseworkItems);

        return course;
    }

    private List<CourseworkItem> getCourseworkItemsForCourse(org.shelbourne.ben.scc300.generated.lancaster.module.Assessment assessmentItem, Item item) {
        List<CourseworkItemEntity> courseworkItemEntities = courseworkItemRepository.findByLusiCourseId(item.getLusiCourseId());
        if (courseworkItemEntities == null || courseworkItemEntities.size() == 0) {
            courseworkItemEntities = assessmentItem.getItems().stream().map(ai -> {
                List<CalendarEvent> assessmentTrackings = assessmentTrackingService.getCalendarEventsForWorkId(ai.getLusiWorkId());
//                if (assessmentTrackings == null || assessmentTrackings.size() == 0) {
//                    LocalDateTime startTime = getRandomStart();
//                    LocalDateTime endTime = startTime.plusHours(RANDOM.nextInt(3));
//                    CalendarEvent calendarEvent = new CalendarEvent()
//                        .lusiWorkId(ai.getLusiWorkId())
//                        .username("testUser")
//                        .eventStatus(CalendarEventStatus.TODO)
//                        .eventType(CalendarEventType.COURSEWORK_TRACKING)
//                        .location("Flat")
//                        .start(startTime)
//                        .plannedStart(startTime)
//                        .end(endTime)
//                        .plannedEnd(endTime)
//                        .title(item.getName());
//                    calendarEvent = assessmentTrackingService.upsert(calendarEvent);
//                    assessmentTrackings = Arrays.asList(calendarEvent);
//                }
                CourseworkItemEntity courseworkItemEntity = CourseworkItemEntity.builder()
                    .name(ai.getName())
                    .dueDate(ai.getDueDate())
                    .graded(ai.getGraded())
                    .lusiWorkId(ai.getLusiWorkId())
                    .moodleUrl(ai.getMoodleUrl())
                    .submissions(ai.getSubmissions())
                    .hasTurnItIn(ai.getHasTurnItIn())
                    .isElective(ai.getIsElective())
                    .isSubmittedLusi(ai.getIsSubmittedLusi())
                    .isSubmittedMoodle(ai.getIsSubmittedMoodle())
                    .status(AssessmentStatus.TODO)
                    .completionPercent(0)
                    .build();

                courseworkItemEntity = courseworkItemRepository.save(courseworkItemEntity);
                courseworkItemEntity.setTracking(assessmentTrackings.stream().map(at -> modelMapper.map(at, CalendarEventEntity.class)).collect(Collectors.toList()));
                return courseworkItemEntity;
            }).collect(Collectors.toList());
        }

        return courseworkItemEntities.stream().map(cie -> modelMapper.map(cie, CourseworkItem.class)).collect(Collectors.toList());
    }

    private LocalDateTime getRandomStart() {
        return LocalDateTime.now()
            .plusDays(RANDOM.nextInt(7))
            .with(ChronoField.HOUR_OF_DAY, (9 + RANDOM.nextInt(8)))
            .with(ChronoField.MINUTE_OF_HOUR, 0)
            .with(ChronoField.SECOND_OF_MINUTE, 0)
            .with(ChronoField.NANO_OF_SECOND, 0);
    }
}
