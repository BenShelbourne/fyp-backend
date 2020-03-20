package org.shelbourne.ben.scc300.repository.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.shelbourne.ben.scc300.generated.model.AssessmentStatus;
import org.shelbourne.ben.scc300.generated.model.CalendarEventStatus;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Entity(name = "courseworkItem")
public class CourseworkItemEntity {

    @Id
    @Column(length = 32, nullable = false)
    private String lusiWorkId;

    private String lusiCourseId;

    private String name;
    private String dueDate;
    private Boolean isElective = null;
    private Boolean isSubmittedMoodle = null;
    private Boolean isSubmittedLusi = null;
    private Boolean hasTurnItIn = null;
    private String moodleUrl;
    private String submissions;
    private Integer graded;
    private Integer completionPercent;
    private Long plannedTimeInSeconds;
    private Long actualTimeInSeconds;
    private Integer completionPercentByTimeInSeconds;
    private AssessmentStatus status;

    @Transient
    private List<CalendarEventEntity> tracking = null;


    public void setTracking(List<CalendarEventEntity> tracking) {
        this.tracking = tracking;
        AssessmentStatus assessmentStatus = AssessmentStatus.TODO;
        if (this.tracking != null && this.tracking.size() > 0) {
            int percent = 0;
            AtomicLong completeSeconds = new AtomicLong(0);
            AtomicLong plannedSeconds = new AtomicLong(0);
            Map<CalendarEventStatus, Integer> statusCounts = new HashMap<>();
            tracking.forEach(e -> {
                plannedSeconds.addAndGet(e.getPlannedTimeInSeconds());
                completeSeconds.addAndGet(e.getActualTimeInSeconds());

                if (statusCounts.containsKey(e.getEventStatus())) {
                    int count = statusCounts.get(e.getEventStatus()) + 1;
                    statusCounts.put(e.getEventStatus(), count);
                } else {
                    statusCounts.put(e.getEventStatus(), 1);
                }
            });

            if (statusCounts.containsKey(CalendarEventStatus.IN_PROGRESS)) {
                assessmentStatus = AssessmentStatus.IN_PROGRESS;
            } else if (statusCounts.containsKey(CalendarEventStatus.COMPLETED)) {
                percent = statusCounts.get(CalendarEventStatus.COMPLETED) * 100 / tracking.size();
                if (percent >= 100) {
                    assessmentStatus = AssessmentStatus.TRACKING_COMPLETE;
                }
            }
            if (assessmentStatus == AssessmentStatus.TODO && percent > 0) {
                assessmentStatus = AssessmentStatus.IN_PROGRESS;
            }
            setCompletionPercent(percent);
            setStatus(assessmentStatus);
            setPlannedTimeInSeconds(plannedSeconds.get());
            setActualTimeInSeconds(completeSeconds.get());
            if (plannedSeconds.get() != 0) {
                int completePercent = (int) (completeSeconds.get() * 100 / plannedSeconds.get());
                setCompletionPercentByTimeInSeconds(completePercent);
            }
        }
    }
}
