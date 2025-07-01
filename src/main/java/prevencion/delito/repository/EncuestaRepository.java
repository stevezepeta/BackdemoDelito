package prevencion.delito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.Encuesta;

public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {
    List<Encuesta> findByActivoTrue();
List<Encuesta> findByPantallaAndActivoTrue(String pantalla);

}
