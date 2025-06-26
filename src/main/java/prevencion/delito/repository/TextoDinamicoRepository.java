package prevencion.delito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.TextoDinamico;

import java.util.Optional;

public interface TextoDinamicoRepository extends JpaRepository<TextoDinamico, Long> {
    Optional<TextoDinamico> findByClave(String clave);
}
