package cwiklinski.me.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "subjects",
        "requestDateTime",
        "requestId"
})
public class Result implements Serializable {

    @JsonProperty("subjects")
    private List<Subject> subjects = null;
    @JsonProperty("requestDateTime")
    private String requestDateTime;
    @JsonProperty("requestId")
    private String requestId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7607568622468895416L;

    public Result() {
    }

    public Result(List<Subject> subjects, String requestDateTime, String requestId) {
        super();
        this.subjects = subjects;
        this.requestDateTime = requestDateTime;
        this.requestId = requestId;
    }

    @JsonProperty("subjects")
    public List<Subject> getSubjects() {
        return subjects;
    }

    @JsonProperty("subjects")
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @JsonProperty("requestDateTime")
    public String getRequestDateTime() {
        return requestDateTime;
    }

    @JsonProperty("requestDateTime")
    public void setRequestDateTime(String requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    @JsonProperty("requestId")
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
