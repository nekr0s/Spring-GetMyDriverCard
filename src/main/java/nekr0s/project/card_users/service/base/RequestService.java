package nekr0s.project.card_users.service.base;

import java.util.List;

import nekr0s.project.card_users.models.clientmodel.ClientRequest;
import nekr0s.project.card_users.models.enums.RequestStatus;

public interface RequestService {
    ClientRequest getRequestById(int id);

    List<ClientRequest> getUserRequests(int userId);

    List<ClientRequest> getAllRequests();

    ClientRequest submitRequest(ClientRequest request);

    void updateRequestStatus(int requestId, RequestStatus requestStatus);
}
