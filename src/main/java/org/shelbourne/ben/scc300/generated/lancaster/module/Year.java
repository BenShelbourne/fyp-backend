
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "text"
})
public class Year {

    @JsonProperty("id")
    private String id;
    @JsonProperty("text")
    private String text;


    /**
     * No args constructor for use in serialization
     */
    public Year() {
    }

    /**
     * @param id
     * @param text
     */
    public Year(String id, String text) {
        super();
        this.id = id;
        this.text = text;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Year withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    public Year withText(String text) {
        this.text = text;
        return this;
    }
}
