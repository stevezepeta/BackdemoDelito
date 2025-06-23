package prevencion.delito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prevencion.delito.model.UiComponent;
import prevencion.delito.repository.UiComponentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UiComponentService {

    @Autowired
    private UiComponentRepository repository;

    public List<UiComponent> getAllComponents() {
        return repository.findAll();
    }

    public Optional<UiComponent> getComponentById(Long id) {
        return repository.findById(id);
    }

    public UiComponent saveComponent(UiComponent component) {
        component.setLastUpdated(LocalDateTime.now());
        return repository.save(component);
    }

    public void deleteComponent(Long id) {
        repository.deleteById(id);
    }
}
