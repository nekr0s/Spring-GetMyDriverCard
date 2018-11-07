package nekr0s.project.card_users.models.clientmodel;

import javax.validation.constraints.NotNull;

import nekr0s.project.card_users.models.Attachment;
import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.enums.RequestReason;
import nekr0s.project.card_users.models.enums.RequestStatus;
import nekr0s.project.card_users.models.enums.RequestType;

public class ClientRequest {

    private int requestId;
    private RequestStatus requestStatus;
    private RequestType requestType;
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
        this.requestStatus = requestStatus;
        this.requestType = requestType;
        this.requestReason = requestReason;
        this.requestDate = requestDate;
        this.attachment = requestAttachment;
        this.user = requestClientUser;
    }

    public ClientRequest(Request request, ClientUser user) {
        this.requestId = request.getRequestId();
        this.requestStatus = request.getRequestStatus();
        this.requestType = request.getRequestType();
        this.requestReason = request.getRequestReason();
        this.requestDate = request.getRequestDate();
        this.attachment = request.getAttachment();
        this.user = user;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public @NotNull RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public @NotNull RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
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
