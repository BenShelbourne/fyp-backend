
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "items",
    "key",
    "coursesCompleted",
    "summary"
})
public class Section {

    @JsonProperty("name")
    private String name;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("key")
    private String key;
    @JsonProperty("coursesCompleted")
    private Integer coursesCompleted;
    @JsonProperty("summary")
    private String summary;


    /**
     * No args constructor for use in serialization
     */
    public Section() {
    }

    /**
     * @param summary
     * @param name
     * @param coursesCompleted
     * @param items
     * @param key
     */
    public Section(String name, List<Item> items, String key, Integer coursesCompleted, String summary) {
        super();
        this.name = name;
        this.items = items;
        this.key = key;
        this.coursesCompleted = coursesCompleted;
        this.summary = summary;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Section withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Section withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    public Section withKey(String key) {
        this.key = key;
        return this;
    }

    @JsonProperty("coursesCompleted")
    public Integer getCoursesCompleted() {
        return coursesCompleted;
    }

    @JsonProperty("coursesCompleted")
    public void setCoursesCompleted(Integer coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
    }

    public Section withCoursesCompleted(Integer coursesCompleted) {
        this.coursesCompleted = coursesCompleted;
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

    public Section withSummary(String summary) {
        this.summary = summary;
        return this;
    }
}
