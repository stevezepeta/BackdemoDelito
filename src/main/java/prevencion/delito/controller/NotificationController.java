package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prevencion.delito.service.FirebaseMessagingService;
import prevencion.delito.dto.NotificationRequest;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    @Autowired
    private FirebaseMessagingService firebaseMessagingService;

    // 🎯 Notificación a un token específico
    @PostMapping("/token")
    public ResponseEntity<String> sendToToken(@RequestBody NotificationRequest request) {
        String response = firebaseMessagingService.sendNotificationToToken(
            request.getToken(), request.getTitle(), request.getBody()
        );
        return ResponseEntity.ok("✅ Enviado a token:\n" + response);
    }

    // 🌐 Notificación a todos los dispositivos suscritos al topic "global"
    @PostMapping("/topic")
    public ResponseEntity<String> sendToTopic(@RequestBody NotificationRequest request) {
        String response = firebaseMessagingService.sendNotificationToTopic(
            "global", request.getTitle(), request.getBody()
        );
        return ResponseEntity.ok("📢 Enviado al topic global:\n" + response);
    }
}
