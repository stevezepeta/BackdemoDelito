package prevencion.delito.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.service.PushNotificationService;

@RestController
@RequestMapping("/api/push")
public class PushNotificationController {

    @Autowired
    private PushNotificationService pushService;

    @PostMapping("/send")
    public String sendManualNotification(@RequestBody NotificationRequest request) {
        pushService.sendGlobalNotification(request.getTitle(), request.getMessage());
        return "Push enviado exitosamente.";
    }

    // DTO interno
    public static class NotificationRequest {
        private String title;
        private String message;

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }
}
