package nekr0s.project.card_users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import nekr0s.project.card_users.models.clientmodel.ClientRequest;
import nekr0s.project.card_users.service.base.RequestService;

@RestController
@RequestMapping("api/requests")
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public List<ClientRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/secured/{userId}/all")
    public List<ClientRequest> getAllRequests(@PathVariable int userId) {
        return requestService.getUserRequests(userId);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/{requestId}")
    public ClientRequest getRequestById(@PathVariable int requestId) {
        return requestService.getRequestById(requestId);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping(consumes = "application/json")
    @ResponseBody
    public ClientRequest submitRequest(@RequestBody ClientRequest request) {
        return requestService.submitRequest(request);
    }
}
