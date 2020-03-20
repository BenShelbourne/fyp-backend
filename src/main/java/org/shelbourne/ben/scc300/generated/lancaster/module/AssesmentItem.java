
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lusiWorkId",
    "name",
    "dueDate",
    "isElective",
    "isSubmittedMoodle",
    "isSubmittedLusi",
    "hasTurnItIn",
    "moodleUrl",
    "submissions",
    "graded"
})
public class AssesmentItem {

    @JsonProperty("lusiWorkId")
    private String lusiWorkId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dueDate")
    private String dueDate;
    @JsonProperty("isElective")
    private Boolean isElective;
    @JsonProperty("isSubmittedMoodle")
    private Boolean isSubmittedMoodle;
    @JsonProperty("isSubmittedLusi")
    private Boolean isSubmittedLusi;
    @JsonProperty("hasTurnItIn")
    private Boolean hasTurnItIn;
    @JsonProperty("moodleUrl")
    private String moodleUrl;
    @JsonProperty("submissions")
    private String submissions;
    @JsonProperty("graded")
    private Integer graded;

    @JsonProperty("lusiWorkId")
    public String getLusiWorkId() {
        return lusiWorkId;
    }

    @JsonProperty("lusiWorkId")
    public void setLusiWorkId(String lusiWorkId) {
        this.lusiWorkId = lusiWorkId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("dueDate")
    public String getDueDate() {
        return dueDate;
    }

    @JsonProperty("dueDate")
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("isElective")
    public Boolean getIsElective() {
        return isElective;
    }

    @JsonProperty("isElective")
    public void setIsElective(Boolean isElective) {
        this.isElective = isElective;
    }

    @JsonProperty("isSubmittedMoodle")
    public Boolean getIsSubmittedMoodle() {
        return isSubmittedMoodle;
    }

    @JsonProperty("isSubmittedMoodle")
    public void setIsSubmittedMoodle(Boolean isSubmittedMoodle) {
        this.isSubmittedMoodle = isSubmittedMoodle;
    }

    @JsonProperty("isSubmittedLusi")
    public Boolean getIsSubmittedLusi() {
        return isSubmittedLusi;
    }

    @JsonProperty("isSubmittedLusi")
    public void setIsSubmittedLusi(Boolean isSubmittedLusi) {
        this.isSubmittedLusi = isSubmittedLusi;
    }

    @JsonProperty("hasTurnItIn")
    public Boolean getHasTurnItIn() {
        return hasTurnItIn;
    }

    @JsonProperty("hasTurnItIn")
    public void setHasTurnItIn(Boolean hasTurnItIn) {
        this.hasTurnItIn = hasTurnItIn;
    }

    @JsonProperty("moodleUrl")
    public String getMoodleUrl() {
        return moodleUrl;
    }

    @JsonProperty("moodleUrl")
    public void setMoodleUrl(String moodleUrl) {
        this.moodleUrl = moodleUrl;
    }

    @JsonProperty("submissions")
    public String getSubmissions() {
        return submissions;
    }

    @JsonProperty("submissions")
    public void setSubmissions(String submissions) {
        this.submissions = submissions;
    }

    @JsonProperty("graded")
    public Integer getGraded() {
        return graded;
    }

    @JsonProperty("graded")
    public void setGraded(Integer graded) {
        this.graded = graded;
    }
}
