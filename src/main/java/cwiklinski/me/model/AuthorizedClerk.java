package cwiklinski.me.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "companyName",
        "firstName",
        "lastName",
        "nip",
        "pesel"
})
public class AuthorizedClerk implements Serializable {

    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("nip")
    private String nip;
    @JsonProperty("pesel")
    private Object pesel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -307315661905358317L;

    public AuthorizedClerk() {
    }

    public AuthorizedClerk(String companyName, String firstName, String lastName, String nip, Object pesel) {
        super();
        this.companyName = companyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nip = nip;
        this.pesel = pesel;
    }

    @JsonProperty("companyName")
    public String getCompanyName() {
        return companyName;
    }

    @JsonProperty("companyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("nip")
    public String getNip() {
        return nip;
    }

    @JsonProperty("nip")
    public void setNip(String nip) {
        this.nip = nip;
    }

    @JsonProperty("pesel")
    public Object getPesel() {
        return pesel;
    }

    @JsonProperty("pesel")
    public void setPesel(Object pesel) {
        this.pesel = pesel;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "AuthorizedClerk{" +
                "companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nip='" + nip + '\'' +
                ", pesel=" + pesel +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

}
