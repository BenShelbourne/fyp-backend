
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url",
    "activityId",
    "priority",
    "instanceKey",
    "summary",
    "showForumsAnnouncements"
})
public class LearningSpace {

    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("activityId")
    private Integer activityId;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("instanceKey")
    private String instanceKey;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("showForumsAnnouncements")
    private Boolean showForumsAnnouncements;


    /**
     * No args constructor for use in serialization
     */
    public LearningSpace() {
    }

    /**
     * @param summary
     * @param activityId
     * @param showForumsAnnouncements
     * @param name
     * @param priority
     * @param url
     * @param instanceKey
     */
    public LearningSpace(String name, String url, Integer activityId, Integer priority, String instanceKey, String summary, Boolean showForumsAnnouncements) {
        super();
        this.name = name;
        this.url = url;
        this.activityId = activityId;
        this.priority = priority;
        this.instanceKey = instanceKey;
        this.summary = summary;
        this.showForumsAnnouncements = showForumsAnnouncements;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public LearningSpace withName(String name) {
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

    public LearningSpace withUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("activityId")
    public Integer getActivityId() {
        return activityId;
    }

    @JsonProperty("activityId")
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public LearningSpace withActivityId(Integer activityId) {
        this.activityId = activityId;
        return this;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LearningSpace withPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    @JsonProperty("instanceKey")
    public String getInstanceKey() {
        return instanceKey;
    }

    @JsonProperty("instanceKey")
    public void setInstanceKey(String instanceKey) {
        this.instanceKey = instanceKey;
    }

    public LearningSpace withInstanceKey(String instanceKey) {
        this.instanceKey = instanceKey;
        return this;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LearningSpace withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    @JsonProperty("showForumsAnnouncements")
    public Boolean getShowForumsAnnouncements() {
        return showForumsAnnouncements;
    }

    @JsonProperty("showForumsAnnouncements")
    public void setShowForumsAnnouncements(Boolean showForumsAnnouncements) {
        this.showForumsAnnouncements = showForumsAnnouncements;
    }

    public LearningSpace withShowForumsAnnouncements(Boolean showForumsAnnouncements) {
        this.showForumsAnnouncements = showForumsAnnouncements;
        return this;
    }
}
