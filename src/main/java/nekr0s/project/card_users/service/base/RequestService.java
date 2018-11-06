package nekr0s.project.card_users.service.base;

import java.util.List;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.clientmodel.ClientRequest;

public interface RequestService {
    Request getRequestById(int id);

    List<Request> getUserRequests(int userId);

    List<Request> getAllRequests();

    ClientRequest submitRequest(ClientRequest request);

    void updateRequestStatus(int requestId, int requestStatus);
}
