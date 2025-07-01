package prevencion.delito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.Respuesta;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByUsuarioId(Long usuarioId);
}
