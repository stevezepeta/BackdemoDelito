package prevencion.delito.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    public void sendGlobalNotification(String title, String body) {
        try {
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build();

            Message message = Message.builder()
                    .setNotification(notification)
                    .setTopic("global")
                    .build();

            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Push enviado: " + response);

        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
        }
    }
}
