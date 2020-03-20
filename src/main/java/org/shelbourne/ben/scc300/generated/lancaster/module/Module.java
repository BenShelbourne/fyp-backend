
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceStatus",
    "years",
    "sections"
})
public class Module {

    @JsonProperty("serviceStatus")
    private List<ServiceStatus> serviceStatus = null;
    @JsonProperty("years")
    private List<Year> years = null;
    @JsonProperty("sections")
    private List<Section> sections = null;


    /**
     * No args constructor for use in serialization
     */
    public Module() {
    }

    /**
     * @param serviceStatus
     * @param years
     * @param sections
     */
    public Module(List<ServiceStatus> serviceStatus, List<Year> years, List<Section> sections) {
        super();
        this.serviceStatus = serviceStatus;
        this.years = years;
        this.sections = sections;
    }

    @JsonProperty("serviceStatus")
    public List<ServiceStatus> getServiceStatus() {
        return serviceStatus;
    }

    @JsonProperty("serviceStatus")
    public void setServiceStatus(List<ServiceStatus> serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Module withServiceStatus(List<ServiceStatus> serviceStatus) {
        this.serviceStatus = serviceStatus;
        return this;
    }

    @JsonProperty("years")
    public List<Year> getYears() {
        return years;
    }

    @JsonProperty("years")
    public void setYears(List<Year> years) {
        this.years = years;
    }

    public Module withYears(List<Year> years) {
        this.years = years;
        return this;
    }

    @JsonProperty("sections")
    public List<Section> getSections() {
        return sections;
    }

    @JsonProperty("sections")
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Module withSections(List<Section> sections) {
        this.sections = sections;
        return this;
    }
}
