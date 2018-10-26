package nekr0s.project.card_users.service;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.repositories.base.RequestRepository;
import nekr0s.project.card_users.service.base.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Request getRequestById(int id) {
        return requestRepository.getRequestById(id);
    }

    @Override
    public List<Request> getUserRequests(int userId) {
        return getUserRequests(userId);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.getAllRequests();
    }

    @Override
    public void updateRequestStatus(int requestId, int requestStatus) {
        requestRepository.updateRequestStatus(requestId, requestStatus);
    }
}
