package nekr0s.project.card_users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.models.UserInfo;
import nekr0s.project.card_users.models.clientmodel.ClientRequest;
import nekr0s.project.card_users.repositories.AttachmentRepository;
import nekr0s.project.card_users.repositories.RequestRepository;
import nekr0s.project.card_users.repositories.UserInfoRepository;
import nekr0s.project.card_users.service.base.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final UserInfoRepository userInfoRepository;
    private final AttachmentRepository attachmentRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository requestRepository,
                              UserInfoRepository userInfoRepository,
                              AttachmentRepository attachmentRepository) {
        this.requestRepository = requestRepository;
        this.userInfoRepository = userInfoRepository;
        this.attachmentRepository = attachmentRepository;
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
    public ClientRequest submitRequest(ClientRequest request) {
        UserInfo userInfo = request.getUser().getUserInfo();
        userInfo.setUserInfoUser(new User(request.getUser()));
        Request realRequest = new Request(request);
        attachmentRepository.save(realRequest.getAttachment());
        userInfoRepository.save(userInfo);
        requestRepository.save(realRequest);
        return request;
    }

    @Override
    public void updateRequestStatus(int requestId, int requestStatus) {
        requestRepository.setRequestStatusById(requestId, requestStatus);
    }
}
