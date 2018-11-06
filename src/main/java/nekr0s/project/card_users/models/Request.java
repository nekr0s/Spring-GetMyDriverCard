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
        this.requestType = clientRequest.getType();
        this.requestStatus = clientRequest.getStatus();
        this.user = new User(clientRequest.getUser());
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
}
