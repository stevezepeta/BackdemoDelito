// IconoRepository.java
package prevencion.delito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.Icono;

public interface IconoRepository extends JpaRepository<Icono, Long> {
    Icono findTopByOrderByIdDesc();  // 🔧 este es el método que te falta
}
