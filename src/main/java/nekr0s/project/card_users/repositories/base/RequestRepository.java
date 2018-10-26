package nekr0s.project.card_users.repositories.base;

import nekr0s.project.card_users.models.Request;

import java.util.List;

public interface RequestRepository {
    Request getRequestById(int id);

    List<Request> getUserRequests(int userId);

    List<Request> getAllRequests();

    void updateRequestStatus(int requestId, int requestStatus);
}
