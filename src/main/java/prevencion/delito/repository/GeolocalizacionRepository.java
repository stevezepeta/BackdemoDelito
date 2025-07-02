package prevencion.delito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prevencion.delito.model.Geolocalizacion;

public interface GeolocalizacionRepository extends JpaRepository<Geolocalizacion, Long> {
}
