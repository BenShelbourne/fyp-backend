package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startDate",
    "endDate",
    "filterEndDate",
    "filterStartDate",
    "externalLinks"
})
public class CourseInfo {

    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("filterEndDate")
    private String filterEndDate;
    @JsonProperty("filterStartDate")
    private String filterStartDate;
    @JsonProperty("externalLinks")
    private List<ExternalLink> externalLinks = null;


    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("filterEndDate")
    public String getFilterEndDate() {
        return filterEndDate;
    }

    @JsonProperty("filterEndDate")
    public void setFilterEndDate(String filterEndDate) {
        this.filterEndDate = filterEndDate;
    }

    @JsonProperty("filterStartDate")
    public String getFilterStartDate() {
        return filterStartDate;
    }

    @JsonProperty("filterStartDate")
    public void setFilterStartDate(String filterStartDate) {
        this.filterStartDate = filterStartDate;
    }

    @JsonProperty("externalLinks")
    public List<ExternalLink> getExternalLinks() {
        return externalLinks;
    }

    @JsonProperty("externalLinks")
    public void setExternalLinks(List<ExternalLink> externalLinks) {
        this.externalLinks = externalLinks;
    }
}
