package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.model.UiComponent;
import prevencion.delito.service.UiComponentService;
import prevencion.delito.service.ConfigVersionService;
import prevencion.delito.service.PushNotificationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/components")
public class UiComponentController {

    @Autowired
    private UiComponentService componentService;

    @Autowired
    private ConfigVersionService versionService;

    @Autowired
    private PushNotificationService pushService;

    @GetMapping
    public List<UiComponent> getAllComponents() {
        return componentService.getAllComponents();
    }

    @GetMapping("/{id}")
    public Optional<UiComponent> getComponentById(@PathVariable Long id) {
        return componentService.getComponentById(id);
    }

    @PostMapping
    public UiComponent createOrUpdateComponent(@RequestBody UiComponent component) {
        UiComponent saved = componentService.saveComponent(component);
        versionService.incrementVersion();

        pushService.sendGlobalNotification(
            "Actualización de configuración",
            "Se ha modificado la interfaz de la aplicación"
        );

        return saved;
    }

    @DeleteMapping("/{id}")
    public void deleteComponent(@PathVariable Long id) {
        componentService.deleteComponent(id);
        versionService.incrementVersion();

        pushService.sendGlobalNotification(
            "Eliminación de componente",
            "Se ha eliminado un componente de la aplicación"
        );
    }

    @GetMapping("/version")
    public int getConfigVersion() {
        return versionService.getLatestVersion().getVersion();
    }
}
