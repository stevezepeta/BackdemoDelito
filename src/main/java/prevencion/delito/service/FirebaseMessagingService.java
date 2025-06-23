package prevencion.delito.service;

import com.google.firebase.messaging.*;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {

    // 🔔 Enviar notificación a un dispositivo por token
    public String sendNotificationToToken(String token, String title, String body) {
        Notification notification = Notification.builder()
            .setTitle(title)
            .setBody(body)
            .build();

        Message message = Message.builder()
            .setNotification(notification)
            .setToken(token)
            .putData("click_action", "FLUTTER_NOTIFICATION_CLICK")
            .build();

        try {
            return FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return "Error al enviar notificación a token: " + e.getMessage();
        }
    }

    // 🌍 Enviar notificación a un topic (todos los suscritos)
    public String sendNotificationToTopic(String topic, String title, String body) {
        Notification notification = Notification.builder()
            .setTitle(title)
            .setBody(body)
            .build();

        Message message = Message.builder()
            .setNotification(notification)
            .setTopic(topic)
            .putData("click_action", "FLUTTER_NOTIFICATION_CLICK")
            .build();

        try {
            return FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
            e.printStackTrace();
            return "Error al enviar notificación a topic: " + e.getMessage();
        }
    }
}
