
package org.shelbourne.ben.scc300.generated.lancaster.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "status",
    "message",
    "lastCachedUtc"
})
public class ServiceStatus {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private Object message;
    @JsonProperty("lastCachedUtc")
    private String lastCachedUtc;

    /**
     * No args constructor for use in serialization
     */
    public ServiceStatus() {
    }

    /**
     * @param name
     * @param id
     * @param message
     * @param status
     * @param lastCachedUtc
     */
    public ServiceStatus(String id, String name, Integer status, Object message, String lastCachedUtc) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.message = message;
        this.lastCachedUtc = lastCachedUtc;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public ServiceStatus withId(String id) {
        this.id = id;
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

    public ServiceStatus withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    public ServiceStatus withStatus(Integer status) {
        this.status = status;
        return this;
    }

    @JsonProperty("message")
    public Object getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Object message) {
        this.message = message;
    }

    public ServiceStatus withMessage(Object message) {
        this.message = message;
        return this;
    }

    @JsonProperty("lastCachedUtc")
    public String getLastCachedUtc() {
        return lastCachedUtc;
    }

    @JsonProperty("lastCachedUtc")
    public void setLastCachedUtc(String lastCachedUtc) {
        this.lastCachedUtc = lastCachedUtc;
    }

    public ServiceStatus withLastCachedUtc(String lastCachedUtc) {
        this.lastCachedUtc = lastCachedUtc;
        return this;
    }

}
