package nekr0s.project.card_users.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestId;

    @Column(name = "RequestType")
    @NotNull
    @Max(40)
    private int requestType;

    @Column(name = "RequestStatus")
    @NotNull
    @Max(3)
    private int requestStatus;

    @Column(name = "RequestDate")
    @NotNull
    @Size(min = 16, max = 16)
    private String requestDate;

    @OneToOne
    @JoinColumn(name = "Requests_AttachmentID", referencedColumnName = "AttachmentID")
    private Attachment attachment;

    @ManyToOne
    @JoinColumn(name = "Requests_UserID", referencedColumnName = "UserID")
    private User user;

    public Request(int requestType, int requestStatus, String requestDate, User user) {
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.requestDate = requestDate;
        this.user = user;
    }

    public Request() {
        // keep empty
    }

    public @NotNull @Max(40) int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public @NotNull @Max(3) int getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(int requestStatus) {
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
}
