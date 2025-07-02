package prevencion.delito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
}
