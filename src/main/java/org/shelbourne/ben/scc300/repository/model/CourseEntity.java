package org.shelbourne.ben.scc300.repository.model;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Transient;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Entity(name = "course")
public class CourseEntity {

    @Id
    private String lusiCourseId;

    private String lusiYearId;
    private String lusiCohortId;
    private String name;
    private String startDate;
    private String endDate;

    @Transient
    private List<CourseworkItemEntity> coursework = null;

}
