package nekr0s.project.card_users.service.base;

import nekr0s.project.card_users.models.Request;

import java.util.List;

public interface RequestService {
    Request getRequestById(int id);

    List<Request> getUserRequests(int userId);

    List<Request> getAllRequests();

    void updateRequestStatus(int requestId, int requestStatus);
}
