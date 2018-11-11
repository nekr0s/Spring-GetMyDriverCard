package nekr0s.project.card_users.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import nekr0s.project.card_users.models.clientmodel.ClientRequest;
import nekr0s.project.card_users.notifications.AndroidPushNotificationsService;
import nekr0s.project.card_users.service.base.RequestService;

@RestController
@RequestMapping("api/requests")
public class RequestController {

    private RequestService requestService;

    // Notifications
    private final
    AndroidPushNotificationsService androidPushNotificationsService;

    @Autowired
    public RequestController(RequestService requestService, AndroidPushNotificationsService androidPushNotificationsService) {
        this.requestService = requestService;
        this.androidPushNotificationsService = androidPushNotificationsService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public List<ClientRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/secured/update")
    public ResponseEntity<String> updateRequest(@RequestBody ClientRequest clientRequest) {
        // Update record
        requestService.updateRequestStatus(clientRequest.getRequestId(), clientRequest.getRequestStatus());

        // Build notification
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + clientRequest.getUser().getUsername());
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "Request approved!");
        notification.put("body", "Your request with number " + clientRequest.getRequestId() + " just got " + clientRequest.getRequestStatus().readableName());

        JSONObject data = new JSONObject();
        data.put("username", clientRequest.getUser().getUsername());
        data.put("requestId", clientRequest.getRequestId());
        data.put("requestStatus", clientRequest.getRequestStatus());

        body.put("notification", notification);
        body.put("data", data);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
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
