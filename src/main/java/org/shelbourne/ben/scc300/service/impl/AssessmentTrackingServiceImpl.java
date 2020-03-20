package org.shelbourne.ben.scc300.service.impl;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.shelbourne.ben.scc300.exception.ClashingEventException;
import org.shelbourne.ben.scc300.exception.ItemNotFoundException;
import org.shelbourne.ben.scc300.exception.WrongStateException;
import org.shelbourne.ben.scc300.generated.model.AssessmentStatus;
import org.shelbourne.ben.scc300.generated.model.CalendarEvent;
import org.shelbourne.ben.scc300.generated.model.CalendarEventStatus;
import org.shelbourne.ben.scc300.generated.model.CourseworkItem;
import org.shelbourne.ben.scc300.repository.AssessmentTrackingRepository;
import org.shelbourne.ben.scc300.repository.CourseworkItemRepository;
import org.shelbourne.ben.scc300.repository.model.CalendarEventEntity;
import org.shelbourne.ben.scc300.repository.model.CourseworkItemEntity;
import org.shelbourne.ben.scc300.service.AssessmentTrackingService;
import org.shelbourne.ben.scc300.service.AuthenticationFacade;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@Component
@RequiredArgsConstructor
@Slf4j
public class AssessmentTrackingServiceImpl implements AssessmentTrackingService {

    @Getter
    private final AssessmentTrackingRepository assessmentTrackingRepository;
    private final CourseworkItemRepository courseworkItemRepository;
    private final AuthenticationFacade authentication;
    private final ModelMapper modelMapper;

    @Override
    public List<CalendarEvent> getCalendarEventsForWorkId(String lusiWorkId) {
        CourseworkItemEntity cie = CourseworkItemEntity.builder().lusiWorkId(lusiWorkId).build();
        List<CalendarEventEntity> assessmentTrackingEntityList = assessmentTrackingRepository.findByLusiWorkIdAndUsername(lusiWorkId, authentication.getUsername());
        return assessmentTrackingEntityList.stream().map(ate -> modelMapper.map(ate, CalendarEvent.class)).collect(Collectors.toList());
    }

    @Override
    public List<CalendarEvent> getCalendarEventsForUser(String username) {
        List<CalendarEventEntity> assessmentTrackingEntityList = assessmentTrackingRepository.findByUsername(username);
        return assessmentTrackingEntityList.stream().map(ate -> modelMapper.map(ate, CalendarEvent.class)).collect(Collectors.toList());
    }

    @Override
    public List<CalendarEvent> getCalendarEventsForUser() {
        return getCalendarEventsForUser(authentication.getUsername());
    }

    public CalendarEvent createCalendarEvent(CalendarEventEntity calendarEventEntity) {
        calendarEventEntity = assessmentTrackingRepository.save(calendarEventEntity);
        return modelMapper.map(calendarEventEntity, CalendarEvent.class);
    }

    @Override
    public CalendarEvent addCalendarEvent(CalendarEvent calendarEvent) {
        List<CalendarEventEntity> assessmentTrackingEntityList = assessmentTrackingRepository.findByUsername(authentication.getUsername());

        if (assessmentTrackingEntityList != null && assessmentTrackingEntityList.size() > 0) {
            List<CalendarEvent> clashingEvents = new ArrayList<>();
            assessmentTrackingEntityList.forEach(ate -> {
                if (!calendarEvent.getStart().isBefore(ate.getPlannedStart()) && !calendarEvent.getStart().isBefore(ate.getPlannedEnd())) {
                    //good
                } else if (!calendarEvent.getStart().isAfter(ate.getPlannedStart()) && !calendarEvent.getEnd().isAfter(ate.getPlannedStart())) {
                    // good
                } else {
                    // bad
                    clashingEvents.add(modelMapper.map(ate, CalendarEvent.class));
                }
            });
            if (!clashingEvents.isEmpty()) {
                throw new ClashingEventException(clashingEvents);
            }
        }

        CalendarEventEntity calendarEventEntity = CalendarEventEntity.builder()
            .eventType(calendarEvent.getEventType())
            .eventStatus(calendarEvent.getEventStatus())
            .lusiWorkId(calendarEvent.getLusiWorkId())
            .username(authentication.getUsername())
            .start(calendarEvent.getStart())
            .end(calendarEvent.getEnd())
            .plannedStart(calendarEvent.getStart())
            .plannedEnd(calendarEvent.getEnd())
            .id(calendarEvent.getId())
            .location(calendarEvent.getLocation())
            .resource(calendarEvent.getResource())
            .title(calendarEvent.getTitle())
            .build();
        calendarEventEntity = assessmentTrackingRepository.save(calendarEventEntity);
        return modelMapper.map(calendarEventEntity, CalendarEvent.class);
    }

    @Override
    public CalendarEvent upsert(CalendarEvent assessmentTracking) {
        CalendarEventEntity ate = null;
        if (StringUtils.isEmpty(assessmentTracking.getId())) {
            // A new tracking
            ate = modelMapper.map(assessmentTracking, CalendarEventEntity.class);
            ate = assessmentTrackingRepository.save(ate);
        } else {
            ate = save(assessmentTracking);
        }
        return modelMapper.map(ate, CalendarEvent.class);
    }

    @Override
    public CourseworkItem completeCoursework(String assessmentProgressId) {
        log.debug("completeCoursework called with assessmentProgressId {}",assessmentProgressId);
        Optional<CalendarEventEntity> ate = assessmentTrackingRepository.findById(assessmentProgressId);
        if (ate.isPresent()) {
            CalendarEventEntity calendarEventEntity = ate.get();
            if (calendarEventEntity.getEventStatus() == CalendarEventStatus.IN_PROGRESS) {
            calendarEventEntity.setEnd(LocalDateTime.now());
            calendarEventEntity.setEventStatus(CalendarEventStatus.COMPLETED);
            assessmentTrackingRepository.save(calendarEventEntity);
            CourseworkItem courseworkItem = updateCourseworkItem(calendarEventEntity.getLusiWorkId());
            log.debug("Coursework calendar event marked as completed for {}. New status of couresework is {}, showing {}% completed",
                calendarEventEntity.getId(), courseworkItem.getStatus(), courseworkItem.getCompletionPercent());
            return courseworkItem;
            } else {
                throw new WrongStateException(String.format("CalendarEvent is not IN_PROGRESS. Current State is %s - %s", calendarEventEntity.getEventStatus(),assessmentProgressId));
            }
        } else {
            log.error("Unable to find tracking for {}", assessmentProgressId);
            throw new ItemNotFoundException(String.format("Unable to find tracking for - %s", assessmentProgressId));
        }
    }

    @Override
    public CourseworkItem assessmentFullyCompleted(String lusiWorkId) {
        CourseworkItemEntity courseworkItemEntity = courseworkItemRepository.findByLusiWorkId(lusiWorkId);
        courseworkItemEntity.setStatus(AssessmentStatus.COMPLETED);
        return modelMapper.map(courseworkItemEntity, CourseworkItem.class);
    }

    @Override
    public CourseworkItem startCoursework(String assessmentProgressId) {
        log.debug("startCoursework called with assessmentProgressId {}",assessmentProgressId);
        Optional<CalendarEventEntity> ate = assessmentTrackingRepository.findById(assessmentProgressId);
        if (ate.isPresent()) {
            CalendarEventEntity calendarEventEntity = ate.get();
            if (calendarEventEntity.getEventStatus() == CalendarEventStatus.TODO) {
                calendarEventEntity.setStart(LocalDateTime.now());
                calendarEventEntity.setEventStatus(CalendarEventStatus.IN_PROGRESS);
                calendarEventEntity = assessmentTrackingRepository.save(calendarEventEntity);

                CourseworkItem courseworkItem = updateCourseworkItem(calendarEventEntity.getLusiWorkId());
                log.debug("Coursework calendar event started for {}. New status of couresework is {}, showing {}% completed",
                    calendarEventEntity.getId(), courseworkItem.getStatus(), courseworkItem.getCompletionPercent());
                return courseworkItem;
            } else {
                throw new WrongStateException(String.format("CalendarEvent is not in the TODO state. Current State is %s - %s",calendarEventEntity.getEventStatus(), assessmentProgressId));
            }
        } else {
            log.error("Unable to find tracking for {}", assessmentProgressId);
            throw new ItemNotFoundException(String.format("Unable to find tracking for - %s", assessmentProgressId));
        }
    }

    @Override
    public CourseworkItem deleteAssessmentTracking(String assessmentProgressId) {
        log.debug("deleteAssessmentTracking called with assessmentProgressId {}",assessmentProgressId);
        Optional<CalendarEventEntity> ate = assessmentTrackingRepository.findById(assessmentProgressId);
        if (ate.isPresent()) {
            assessmentTrackingRepository.delete(ate.get());
            CourseworkItem courseworkItem = updateCourseworkItem(ate.get().getLusiWorkId());
            log.debug("Coursework calendar event deleted for {}. New status of couresework is {}, showing {}% completed",
                ate.get().getId(), courseworkItem.getStatus(), courseworkItem.getCompletionPercent());
            return courseworkItem;
        }else {
            log.error("Unable to find tracking for {}", assessmentProgressId);
            throw new ItemNotFoundException(String.format("Unable to find tracking for %s", assessmentProgressId));
        }
    }


    public CourseworkItem updateCourseworkItem(String lusiWorkId) {
        log.debug("updateCourseworkItem called with lusiWorkId {}",lusiWorkId);
        List<CalendarEventEntity> existingEvents = assessmentTrackingRepository.findByLusiWorkId(lusiWorkId);
        CourseworkItemEntity courseworkItemEntity = courseworkItemRepository.findByLusiWorkId(lusiWorkId);
        courseworkItemEntity.setTracking(existingEvents);
        return modelMapper.map(courseworkItemEntity, CourseworkItem.class);
    }

    private CalendarEventEntity save(CalendarEvent assessmentTracking) {
        Optional<CalendarEventEntity> ate = assessmentTrackingRepository.findById(assessmentTracking.getId());
        if (ate.isPresent()) {
            modelMapper.map(assessmentTracking, ate.get());
            return assessmentTrackingRepository.save(ate.get());
        } else {
            throw new ItemNotFoundException(String.format("Unable to find tracking for %s", assessmentTracking));
        }
    }
}
