package nekr0s.project.card_users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import nekr0s.project.card_users.controllers.RequestController;
import nekr0s.project.card_users.models.Request;
import nekr0s.project.card_users.models.User;
import nekr0s.project.card_users.models.UserInfo;
import nekr0s.project.card_users.models.clientmodel.ClientRequest;
import nekr0s.project.card_users.models.clientmodel.ClientUser;
import nekr0s.project.card_users.models.clientmodel.ClientUserInfo;
import nekr0s.project.card_users.models.enums.RequestStatus;
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
    public ClientRequest getRequestById(int id) {
        Request request = requestRepository.getByRequestId(id);
        ClientUserInfo clientUserInfo = new ClientUserInfo(userInfoRepository
                .findByUserInfoUserId(request.getUser().getId()));
        ClientUser clientUser = new ClientUser(clientUserInfo);
        return new ClientRequest(request, clientUser);
    }

    @Override
    public List<ClientRequest> getUserRequests(int userId) {
        List<ClientRequest> clientRequests = new ArrayList<>();
        for (Request request : requestRepository.getAllByUserId(userId)) {
            ClientUserInfo clientUserInfo = new ClientUserInfo(userInfoRepository.findByUserInfoUserId(userId));
            ClientUser clientUser = new ClientUser(clientUserInfo);
            clientRequests.add(new ClientRequest(request, clientUser));
        }
        return clientRequests;
    }

    @Override
    public List<ClientRequest> getAllRequests() {
        List<ClientRequest> clientRequests = new ArrayList<>();
        for (Request request : requestRepository.findAll()) {
            ClientUserInfo clientUserInfo = new ClientUserInfo(userInfoRepository
                    .findByUserInfoUserId(request.getUser().getId()));
            ClientUser clientUser = new ClientUser(clientUserInfo);
            clientRequests.add(new ClientRequest(request, clientUser));
        }
        return clientRequests;
    }

    @Override
    public ClientRequest submitRequest(ClientRequest request) {
        UserInfo userInfo = new UserInfo(request.getUser().getUserInfo(), new User(request.getUser()));
        Request realRequest = new Request(request);
        attachmentRepository.save(realRequest.getAttachment());
        userInfoRepository.save(userInfo);
        requestRepository.save(realRequest);
        return request;
    }

    @Override
    public void updateRequestStatus(int requestId, RequestStatus requestStatus) {
        requestRepository.setRequestStatusById(requestId, requestStatus);
    }
}
