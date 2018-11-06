package nekr0s.project.card_users.models.clientmodel;

import javax.validation.constraints.NotNull;

import nekr0s.project.card_users.models.Attachment;
import nekr0s.project.card_users.models.enums.RequestReason;
import nekr0s.project.card_users.models.enums.RequestStatus;
import nekr0s.project.card_users.models.enums.RequestType;

public class ClientRequest {

    private int requestId;
    private RequestStatus status;
    private RequestType type;
    private RequestReason requestReason;
    private String requestDate;
    private Attachment attachment;
    private ClientUser user;

    public ClientRequest() {
        // keep empty pls
    }

    public ClientRequest(int requestId, RequestStatus requestStatus, RequestType requestType, RequestReason requestReason, String requestDate,
                         Attachment requestAttachment, ClientUser requestClientUser) {
        this.requestId = requestId;
        this.status = requestStatus;
        this.type = requestType;
        this.requestReason = requestReason;
        this.requestDate = requestDate;
        this.attachment = requestAttachment;
        this.user = requestClientUser;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public @NotNull RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public @NotNull RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public ClientUser getUser() {
        return user;
    }

    public void setUser(ClientUser user) {
        this.user = user;
    }

    public RequestReason getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(RequestReason requestReason) {
        this.requestReason = requestReason;
    }
}
