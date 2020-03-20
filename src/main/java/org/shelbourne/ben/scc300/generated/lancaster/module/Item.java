
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lusiYearId",
    "lusiCourseId",
    "lusiCohortId",
    "name",
    "url",
    "isAudit",
    "courseInfo",
    "assessments",
    "learningSpaces",
    "appraisalSpace",
    "skillsSpace"
})
public class Item {

    @JsonProperty("lusiYearId")
    private String lusiYearId;
    @JsonProperty("lusiCourseId")
    private String lusiCourseId;
    @JsonProperty("lusiCohortId")
    private Integer lusiCohortId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("isAudit")
    private Boolean isAudit;
    @JsonProperty("courseInfo")
    private CourseInfo courseInfo;
    @JsonProperty("assessments")
    private List<Assessment> assessments;
    @JsonProperty("learningSpaces")
    private List<LearningSpace> learningSpaces = null;
    @JsonProperty("appraisalSpace")
    private Object appraisalSpace;
    @JsonProperty("skillsSpace")
    private SkillsSpace skillsSpace;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param assessments
     * @param lusiYearId
     * @param isAudit
     * @param appraisalSpace
     * @param skillsSpace
     * @param name
     * @param lusiCourseId
     * @param courseInfo
     * @param learningSpaces
     * @param lusiCohortId
     * @param url
     */
    public Item(String lusiYearId, String lusiCourseId, Integer lusiCohortId, String name, String url, Boolean isAudit, CourseInfo courseInfo, List<Assessment> assessments, List<LearningSpace> learningSpaces, Object appraisalSpace,
        SkillsSpace skillsSpace) {
        super();
        this.lusiYearId = lusiYearId;
        this.lusiCourseId = lusiCourseId;
        this.lusiCohortId = lusiCohortId;
        this.name = name;
        this.url = url;
        this.isAudit = isAudit;
        this.courseInfo = courseInfo;
        this.assessments = assessments;
        this.learningSpaces = learningSpaces;
        this.appraisalSpace = appraisalSpace;
        this.skillsSpace = skillsSpace;
    }

    @JsonProperty("lusiYearId")
    public String getLusiYearId() {
        return lusiYearId;
    }

    @JsonProperty("lusiYearId")
    public void setLusiYearId(String lusiYearId) {
        this.lusiYearId = lusiYearId;
    }

    public Item withLusiYearId(String lusiYearId) {
        this.lusiYearId = lusiYearId;
        return this;
    }

    @JsonProperty("lusiCourseId")
    public String getLusiCourseId() {
        return lusiCourseId;
    }

    @JsonProperty("lusiCourseId")
    public void setLusiCourseId(String lusiCourseId) {
        this.lusiCourseId = lusiCourseId;
    }

    public Item withLusiCourseId(String lusiCourseId) {
        this.lusiCourseId = lusiCourseId;
        return this;
    }

    @JsonProperty("lusiCohortId")
    public Integer getLusiCohortId() {
        return lusiCohortId;
    }

    @JsonProperty("lusiCohortId")
    public void setLusiCohortId(Integer lusiCohortId) {
        this.lusiCohortId = lusiCohortId;
    }

    public Item withLusiCohortId(Integer lusiCohortId) {
        this.lusiCohortId = lusiCohortId;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Item withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public Item withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("isAudit")
    public Boolean getIsAudit() {
        return isAudit;
    }

    @JsonProperty("isAudit")
    public void setIsAudit(Boolean isAudit) {
        this.isAudit = isAudit;
    }

    public Item withIsAudit(Boolean isAudit) {
        this.isAudit = isAudit;
        return this;
    }

    @JsonProperty("courseInfo")
    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    @JsonProperty("courseInfo")
    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Item withCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
        return this;
    }

    @JsonProperty("assessments")
    public List<Assessment> getAssessments() {
        return assessments;
    }

    @JsonProperty("assessments")
    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Item withAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
        return this;
    }

    @JsonProperty("learningSpaces")
    public List<LearningSpace> getLearningSpaces() {
        return learningSpaces;
    }

    @JsonProperty("learningSpaces")
    public void setLearningSpaces(List<LearningSpace> learningSpaces) {
        this.learningSpaces = learningSpaces;
    }

    public Item withLearningSpaces(List<LearningSpace> learningSpaces) {
        this.learningSpaces = learningSpaces;
        return this;
    }

    @JsonProperty("appraisalSpace")
    public Object getAppraisalSpace() {
        return appraisalSpace;
    }

    @JsonProperty("appraisalSpace")
    public void setAppraisalSpace(Object appraisalSpace) {
        this.appraisalSpace = appraisalSpace;
    }

    public Item withAppraisalSpace(Object appraisalSpace) {
        this.appraisalSpace = appraisalSpace;
        return this;
    }

    @JsonProperty("skillsSpace")
    public SkillsSpace getSkillsSpace() {
        return skillsSpace;
    }

    @JsonProperty("skillsSpace")
    public void setSkillsSpace(SkillsSpace skillsSpace) {
        this.skillsSpace = skillsSpace;
    }

    public Item withSkillsSpace(SkillsSpace skillsSpace) {
        this.skillsSpace = skillsSpace;
        return this;
    }
}
