package prevencion.delito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.Opcion;

import java.util.List;

public interface OpcionRepository extends JpaRepository<Opcion, Long> {
List<Opcion> findByActivoTrue();
List<Opcion> findByPreguntaIdAndActivoTrue(Long preguntaId);
}
