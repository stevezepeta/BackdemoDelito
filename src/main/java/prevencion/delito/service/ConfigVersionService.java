package prevencion.delito.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prevencion.delito.model.ConfigVersion;
import prevencion.delito.repository.ConfigVersionRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfigVersionService {

    @Autowired
    private ConfigVersionRepository repository;

    public ConfigVersion getLatestVersion() {
        return repository.findAll()
                         .stream()
                         .findFirst()
                         .orElseGet(() -> {
                             ConfigVersion newVersion = new ConfigVersion();
                             newVersion.setVersion(1);
                             newVersion.setLastUpdated(LocalDateTime.now());
                             return repository.save(newVersion);
                         });
    }

    public ConfigVersion incrementVersion() {
        ConfigVersion current = getLatestVersion();
        current.setVersion(current.getVersion() + 1);
        current.setLastUpdated(LocalDateTime.now());
        return repository.save(current);
    }
}
