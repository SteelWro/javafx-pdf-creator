package cwiklinski.me.model;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "nip",
        "statusVat",
        "regon",
        "pesel",
        "krs",
        "residenceAddress",
        "workingAddress",
        "representatives",
        "authorizedClerks",
        "partners",
        "registrationLegalDate",
        "registrationDenialBasis",
        "registrationDenialDate",
        "restorationBasis",
        "restorationDate",
        "removalBasis",
        "removalDate",
        "accountNumbers",
        "hasVirtualAccounts"
})
public class Subject implements Serializable {

    @JsonProperty("name")
    private String name;
    @JsonProperty("nip")
    private String nip;
    @JsonProperty("statusVat")
    private String statusVat;
    @JsonProperty("regon")
    private String regon;
    @JsonProperty("pesel")
    private String pesel;
    @JsonProperty("krs")
    private String krs;
    @JsonProperty("residenceAddress")
    private String residenceAddress;
    @JsonProperty("workingAddress")
    private String workingAddress;
    @JsonProperty("representatives")
    private List<Representative> representatives = null;
    @JsonProperty("authorizedClerks")
    private List<AuthorizedClerk> authorizedClerks = null;
    @JsonProperty("partners")
    private List<Partner> partners = null;
    @JsonProperty("registrationLegalDate")
    private String registrationLegalDate;
    @JsonProperty("registrationDenialBasis")
    private String registrationDenialBasis;
    @JsonProperty("registrationDenialDate")
    private String registrationDenialDate;
    @JsonProperty("restorationBasis")
    private String restorationBasis;
    @JsonProperty("restorationDate")
    private String restorationDate;
    @JsonProperty("removalBasis")
    private String removalBasis;
    @JsonProperty("removalDate")
    private String removalDate;
    @JsonProperty("accountNumbers")
    private List<String> accountNumbers = null;
    @JsonProperty("hasVirtualAccounts")
    private Boolean hasVirtualAccounts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 1286512862796440700L;

    public Subject() {
    }

    public Subject(String name, String nip, String statusVat, String regon, String pesel, String krs, String residenceAddress, String workingAddress, List<Representative> representatives, List<AuthorizedClerk> authorizedClerks, List<Partner> partners, String registrationLegalDate, String registrationDenialBasis, String registrationDenialDate, String restorationBasis, String restorationDate, String removalBasis, String removalDate, List<String> accountNumbers, Boolean hasVirtualAccounts) {
        super();
        this.name = name;
        this.nip = nip;
        this.statusVat = statusVat;
        this.regon = regon;
        this.pesel = pesel;
        this.krs = krs;
        this.residenceAddress = residenceAddress;
        this.workingAddress = workingAddress;
        this.representatives = representatives;
        this.authorizedClerks = authorizedClerks;
        this.partners = partners;
        this.registrationLegalDate = registrationLegalDate;
        this.registrationDenialBasis = registrationDenialBasis;
        this.registrationDenialDate = registrationDenialDate;
        this.restorationBasis = restorationBasis;
        this.restorationDate = restorationDate;
        this.removalBasis = removalBasis;
        this.removalDate = removalDate;
        this.accountNumbers = accountNumbers;
        this.hasVirtualAccounts = hasVirtualAccounts;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nip")
    public String getNip() {
        return nip;
    }

    @JsonProperty("nip")
    public void setNip(String nip) {
        this.nip = nip;
    }

    @JsonProperty("statusVat")
    public String getStatusVat() {
        return statusVat;
    }

    @JsonProperty("statusVat")
    public void setStatusVat(String statusVat) {
        this.statusVat = statusVat;
    }

    @JsonProperty("regon")
    public String getRegon() {
        return regon;
    }

    @JsonProperty("regon")
    public void setRegon(String regon) {
        this.regon = regon;
    }

    @JsonProperty("pesel")
    public String getPesel() {
        return pesel;
    }

    @JsonProperty("pesel")
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @JsonProperty("krs")
    public String getKrs() {
        return krs;
    }

    @JsonProperty("krs")
    public void setKrs(String krs) {
        this.krs = krs;
    }

    @JsonProperty("residenceAddress")
    public String getResidenceAddress() {
        return residenceAddress;
    }

    @JsonProperty("residenceAddress")
    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    @JsonProperty("workingAddress")
    public String getWorkingAddress() {
        return workingAddress;
    }

    @JsonProperty("workingAddress")
    public void setWorkingAddress(String workingAddress) {
        this.workingAddress = workingAddress;
    }

    @JsonProperty("representatives")
    public List<Representative> getRepresentatives() {
        return representatives;
    }

    @JsonProperty("representatives")
    public void setRepresentatives(List<Representative> representatives) {
        this.representatives = representatives;
    }

    @JsonProperty("authorizedClerks")
    public List<AuthorizedClerk> getAuthorizedClerks() {
        return authorizedClerks;
    }

    @JsonProperty("authorizedClerks")
    public void setAuthorizedClerks(List<AuthorizedClerk> authorizedClerks) {
        this.authorizedClerks = authorizedClerks;
    }

    @JsonProperty("partners")
    public List<Partner> getPartners() {
        return partners;
    }

    @JsonProperty("partners")
    public void setPartners(List<Partner> partners) {
        this.partners = partners;
    }

    @JsonProperty("registrationLegalDate")
    public String getRegistrationLegalDate() {
        return registrationLegalDate;
    }

    @JsonProperty("registrationLegalDate")
    public void setRegistrationLegalDate(String registrationLegalDate) {
        this.registrationLegalDate = registrationLegalDate;
    }

    @JsonProperty("registrationDenialBasis")
    public String getRegistrationDenialBasis() {
        return registrationDenialBasis;
    }

    @JsonProperty("registrationDenialBasis")
    public void setRegistrationDenialBasis(String registrationDenialBasis) {
        this.registrationDenialBasis = registrationDenialBasis;
    }

    @JsonProperty("registrationDenialDate")
    public String getRegistrationDenialDate() {
        return registrationDenialDate;
    }

    @JsonProperty("registrationDenialDate")
    public void setRegistrationDenialDate(String registrationDenialDate) {
        this.registrationDenialDate = registrationDenialDate;
    }

    @JsonProperty("restorationBasis")
    public String getRestorationBasis() {
        return restorationBasis;
    }

    @JsonProperty("restorationBasis")
    public void setRestorationBasis(String restorationBasis) {
        this.restorationBasis = restorationBasis;
    }

    @JsonProperty("restorationDate")
    public String getRestorationDate() {
        return restorationDate;
    }

    @JsonProperty("restorationDate")
    public void setRestorationDate(String restorationDate) {
        this.restorationDate = restorationDate;
    }

    @JsonProperty("removalBasis")
    public String getRemovalBasis() {
        return removalBasis;
    }

    @JsonProperty("removalBasis")
    public void setRemovalBasis(String removalBasis) {
        this.removalBasis = removalBasis;
    }

    @JsonProperty("removalDate")
    public String getRemovalDate() {
        return removalDate;
    }

    @JsonProperty("removalDate")
    public void setRemovalDate(String removalDate) {
        this.removalDate = removalDate;
    }

    @JsonProperty("accountNumbers")
    public List<String> getAccountNumbers() {
        return accountNumbers;
    }

    @JsonProperty("accountNumbers")
    public void setAccountNumbers(List<String> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    @JsonProperty("hasVirtualAccounts")
    public Boolean getHasVirtualAccounts() {
        return hasVirtualAccounts;
    }

    @JsonProperty("hasVirtualAccounts")
    public void setHasVirtualAccounts(Boolean hasVirtualAccounts) {
        this.hasVirtualAccounts = hasVirtualAccounts;
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
