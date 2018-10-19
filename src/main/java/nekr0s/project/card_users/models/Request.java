package nekr0s.project.card_users.models;

import javax.persistence.*;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequestID")
    private int requestId;

    @Column(name = "RequestType")
    private String requestType;

    @Column(name = "RequestStatus")
    private String requestStatus;

    @Column(name = "RequestDate")
    private String requestDate;

    @ManyToOne
    @JoinColumn(name = "RequestsUserID", referencedColumnName = "UserID")
    private User user;

    public Request(String requestType, String requestStatus, String requestDate, User user) {
        this.requestType = requestType;
        this.requestStatus = requestStatus;
        this.requestDate = requestDate;
        this.user = user;
    }

    public Request() {
        // keep empty
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
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
