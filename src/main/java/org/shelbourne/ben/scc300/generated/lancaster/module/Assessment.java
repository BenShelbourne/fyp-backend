package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "viewType",
    "priority",
    "items",
    "noAssessmentStructureMessage"
})
public class Assessment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("viewType")
    private String viewType;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("items")
    private List<AssesmentItem> items = null;
    @JsonProperty("noAssessmentStructureMessage")
    private String noAssessmentStructureMessage;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("viewType")
    public String getViewType() {
        return viewType;
    }

    @JsonProperty("viewType")
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonProperty("items")
    public List<AssesmentItem> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<AssesmentItem> items) {
        this.items = items;
    }

    @JsonProperty("noAssessmentStructureMessage")
    public String getNoAssessmentStructureMessage() {
        return noAssessmentStructureMessage;
    }

    @JsonProperty("noAssessmentStructureMessage")
    public void setNoAssessmentStructureMessage(String noAssessmentStructureMessage) {
        this.noAssessmentStructureMessage = noAssessmentStructureMessage;
    }

}
