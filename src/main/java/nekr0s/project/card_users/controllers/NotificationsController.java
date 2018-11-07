package nekr0s.project.card_users.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import nekr0s.project.card_users.notifications.AndroidPushNotificationsService;

@RestController
public class NotificationsController {
    private final String TOPIC = "GetMyDriverCard";

    private final
    AndroidPushNotificationsService androidPushNotificationsService;

    @Autowired
    public NotificationsController(AndroidPushNotificationsService androidPushNotificationsService) {
        this.androidPushNotificationsService = androidPushNotificationsService;
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> send(String username, int requestId) throws JSONException {
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + TOPIC);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "Request approved!");
        notification.put("body", "Your request with number " + requestId + " just got approved!");

        JSONObject data = new JSONObject();
        data.put("username", username);
        data.put("requestId", requestId);

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
}
