package nekr0s.project.card_users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import nekr0s.project.card_users.models.clientmodel.ClientRequest;
import nekr0s.project.card_users.models.enums.RequestReason;
import nekr0s.project.card_users.models.enums.RequestStatus;
import nekr0s.project.card_users.models.enums.RequestType;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestId;

    @Column(name = "RequestType")
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RequestType requestType;

    @Column(name = "RequestStatus")
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RequestStatus requestStatus;

    @Column(name = "RequestReason")
    @Enumerated(value = EnumType.STRING)
    private RequestReason requestReason;

    @Column(name = "RequestDate")
    @NotNull
    @Size(max = 30)
    private String requestDate;

    @Column(name = "PreviousCountryOfIssuing")
    @Size(max = 25)
    private String previousCountryOfIssuing;

    @Column(name = "PreviousIssuingAuthority")
    @Size(max = 20)
    private String previousIssuingAuthority;

    @Column(name = "PreviousTachCardNum")
    @Size(max = 25)
    private String previousTachCardNum;

    @Column(name = "PreviousDateOfExpiry")
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^\\d+(\\.\\d+)*$")
    private String previousDateOfExpiry;

    @Column(name = "PreviousLostDate")
    @Size(min = 10, max = 10)
    private String previousLostDate;

    @Column(name = "PreviousLostPlace")
    @Size(max = 45)
    private String previousLostPlace;

    @Column(name = "CurrentCountryOfIssuing")
    @Size(max = 25)
    private String currentCountryOfIssuing;

    @Column(name = "CurrentTachCardNum")
    @Size(max = 25)
    private String currentTachCardNum;

    @Column(name = "CurrentDriverLicenseCountryOfIssuing")
    @Size(max = 25)
    private String currentDriverLicenseCountryOfIssuing;

    @Column(name = "CurrentDriverLicenseNumber")
    @Size(max = 25)
    private String currentDriverLicenseNumber;

    @OneToOne()
    @JoinColumn(name = "Requests_AttachmentID", referencedColumnName = "AttachmentID")
    private Attachment attachment;

    @ManyToOne()
    @JoinColumn(name = "Requests_UserID", referencedColumnName = "UserID")
    private User user;

    public Request(@NotNull RequestType requestType, @NotNull RequestStatus requestStatus, String requestDate, User user) {
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.requestDate = requestDate;
        this.user = user;
    }

    public Request() {
        // keep empty
    }

    public Request(ClientRequest clientRequest) {
        this.requestId = clientRequest.getRequestId();
        this.requestDate = clientRequest.getRequestDate();
        this.attachment = clientRequest.getAttachment();
        this.requestType = clientRequest.getRequestType();
        this.requestStatus = clientRequest.getRequestStatus();
        this.user = new User(clientRequest.getUser());
        this.previousCountryOfIssuing = clientRequest.getPreviousCountryOfIssuing();
        this.previousDateOfExpiry = clientRequest.getPreviousDateOfExpiry();
        this.previousIssuingAuthority = clientRequest.getPreviousIssuingAuthority();
        this.previousLostDate = clientRequest.getPreviousLostDate();
        this.previousLostPlace = clientRequest.getPreviousLostPlace();
        this.previousTachCardNum = clientRequest.getPreviousTachCardNum();
        this.currentCountryOfIssuing = clientRequest.getCurrentCountryOfIssuing();
        this.currentDriverLicenseCountryOfIssuing = clientRequest.getCurrentDriverLicenseCountryOfIssuing();
        this.currentDriverLicenseNumber = clientRequest.getCurrentDriverLicenseNumber();
        this.currentTachCardNum = clientRequest.getCurrentTachCardNum();
    }

    public @NotNull RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(@NotNull RequestType requestType) {
        this.requestType = requestType;
    }

    public @NotNull RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(@NotNull RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public RequestReason getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(RequestReason requestReason) {
        this.requestReason = requestReason;
    }

    public String getPreviousCountryOfIssuing() {
        return previousCountryOfIssuing;
    }

    public void setPreviousCountryOfIssuing(String previousCountryOfIssuing) {
        this.previousCountryOfIssuing = previousCountryOfIssuing;
    }

    public String getPreviousIssuingAuthority() {
        return previousIssuingAuthority;
    }

    public void setPreviousIssuingAuthority(String previousIssuingAuthority) {
        this.previousIssuingAuthority = previousIssuingAuthority;
    }

    public String getPreviousTachCardNum() {
        return previousTachCardNum;
    }

    public void setPreviousTachCardNum(String previousTachCardNum) {
        this.previousTachCardNum = previousTachCardNum;
    }

    public String getPreviousDateOfExpiry() {
        return previousDateOfExpiry;
    }

    public void setPreviousDateOfExpiry(String previousDateOfExpiry) {
        this.previousDateOfExpiry = previousDateOfExpiry;
    }

    public String getPreviousLostDate() {
        return previousLostDate;
    }

    public void setPreviousLostDate(String previousLostDate) {
        this.previousLostDate = previousLostDate;
    }

    public String getPreviousLostPlace() {
        return previousLostPlace;
    }

    public void setPreviousLostPlace(String previousLostPlace) {
        this.previousLostPlace = previousLostPlace;
    }

    public String getCurrentCountryOfIssuing() {
        return currentCountryOfIssuing;
    }

    public void setCurrentCountryOfIssuing(String currentCountryOfIssuing) {
        this.currentCountryOfIssuing = currentCountryOfIssuing;
    }

    public String getCurrentTachCardNum() {
        return currentTachCardNum;
    }

    public void setCurrentTachCardNum(String currentTachCardNum) {
        this.currentTachCardNum = currentTachCardNum;
    }

    public String getCurrentDriverLicenseCountryOfIssuing() {
        return currentDriverLicenseCountryOfIssuing;
    }

    public void setCurrentDriverLicenseCountryOfIssuing(String currentDriverLicenseCountryOfIssuing) {
        this.currentDriverLicenseCountryOfIssuing = currentDriverLicenseCountryOfIssuing;
    }

    public String getCurrentDriverLicenseNumber() {
        return currentDriverLicenseNumber;
    }

    public void setCurrentDriverLicenseNumber(String currentDriverLicenseNumber) {
        this.currentDriverLicenseNumber = currentDriverLicenseNumber;
    }
}
