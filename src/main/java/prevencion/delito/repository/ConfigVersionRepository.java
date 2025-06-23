package prevencion.delito.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import prevencion.delito.model.ConfigVersion;

public interface ConfigVersionRepository extends JpaRepository<ConfigVersion, Long> {}
