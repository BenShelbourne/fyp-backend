package org.shelbourne.ben.scc300.repository.model;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.shelbourne.ben.scc300.generated.model.CalendarEventStatus;
import org.shelbourne.ben.scc300.generated.model.CalendarEventType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Entity(name = "calendarEvent")
public class CalendarEventEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 48, nullable = false)
    private String id;

    //@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private String lusiWorkId;

    @Column(length = 64, nullable = false)
    private String username;

    @Column(length = 255)
    private String title;

    private LocalDateTime start;
    private LocalDateTime end;

    private LocalDateTime plannedStart;
    private LocalDateTime plannedEnd;

    @Column(length = 255, nullable = true)
    private String location;

    private CalendarEventType eventType;
    private CalendarEventStatus eventStatus;

    @Column(length = 255, nullable = true)
    private String resource;

    @Column(length = 255, nullable = true)
    private String note;

    private Long plannedTimeInSeconds;
    private Long actualTimeInSeconds;
    private Integer completionPercentByTimeInSeconds;


    public void setStart(LocalDateTime start) {
        this.start = start;
        updateStats();
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
        updateStats();
    }

    public void setPlannedStart(LocalDateTime plannedStart) {
        this.plannedStart = plannedStart;
        updateStats();
    }

    public void setPlannedEnd(LocalDateTime plannedEnd) {
        this.plannedEnd = plannedEnd;
        updateStats();
    }

    public void setEventStatus(CalendarEventStatus eventStatus) {
        this.eventStatus = eventStatus;
       updateStats();
    }

    public void updateStats() {
        plannedTimeInSeconds = 0L;
        actualTimeInSeconds = 0L;
        completionPercentByTimeInSeconds = 0;
        if (getPlannedStart() != null &&
            getPlannedEnd() != null &&
            getStart() != null &&
            getEnd() != null &&
        getEventStatus() != null) {
            plannedTimeInSeconds = ChronoUnit.SECONDS.between(getPlannedStart(), getPlannedEnd());
            if (this.eventStatus == CalendarEventStatus.IN_PROGRESS) {
                actualTimeInSeconds = ChronoUnit.SECONDS.between(getStart(), LocalDateTime.now());
            } else if (this.eventStatus == CalendarEventStatus.COMPLETED) {
                actualTimeInSeconds = ChronoUnit.SECONDS.between(getStart(), getEnd());
            }
            if (plannedTimeInSeconds != 0) {
                completionPercentByTimeInSeconds = (int) (actualTimeInSeconds * 100 / plannedTimeInSeconds);
            } else {
                completionPercentByTimeInSeconds = 0;
            }
        }
    }
}
