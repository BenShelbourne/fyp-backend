package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url",
    "activityId",
    "instanceKey",
    "summary",
    "completed"
})
public class SkillsSpace {

    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("activityId")
    private Integer activityId;
    @JsonProperty("instanceKey")
    private String instanceKey;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("completed")
    private Boolean completed;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("activityId")
    public Integer getActivityId() {
        return activityId;
    }

    @JsonProperty("activityId")
    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @JsonProperty("instanceKey")
    public String getInstanceKey() {
        return instanceKey;
    }

    @JsonProperty("instanceKey")
    public void setInstanceKey(String instanceKey) {
        this.instanceKey = instanceKey;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("completed")
    public Boolean getCompleted() {
        return completed;
    }

    @JsonProperty("completed")
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}