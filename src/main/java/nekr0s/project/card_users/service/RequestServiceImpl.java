package nekr0s.project.card_users.service;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.repositories.RequestRepository;
import nekr0s.project.card_users.service.base.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request getRequestById(int id) {
        return requestRepository.getByRequestId(id);
    }

    @Override
    public List<Request> getUserRequests(int userId) {
        return requestRepository.getAllByUserId(userId);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public void updateRequestStatus(int requestId, int requestStatus) {
        requestRepository.setRequestStatusById(requestId, requestStatus);
    }
}
