package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "assessments"
})
public class Assesments {

    @JsonProperty("assessments")
    private List<Assessment> assessments = null;

    @JsonProperty("assessments")
    public List<Assessment> getAssessments() {
        return assessments;
    }

    @JsonProperty("assessments")
    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }
}
