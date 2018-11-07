package nekr0s.project.card_users.notifications;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class AndroidPushNotificationsService {
    private static final String FIREBASE_SERVER_KEY = "AAAAYvNYqHw:APA91bEobxvC_GCz4Ca9sWt8eTrp3y5HqsxI4_YQBw0PpPox-3vtTkgzAhaI2O4rYUnuMh4zw9vBTrJZFqt60CgF8oCiAL_wyj_AKq-WG9E3A0nZSp1bhPVfYDCY4T5f7q-A3YbOQPBt";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    public CompletableFuture<String> send(HttpEntity<String> entity) {
        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequesterIncerceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequesterIncerceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }
}
