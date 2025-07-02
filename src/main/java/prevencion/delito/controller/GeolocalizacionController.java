package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.model.Geolocalizacion;
import prevencion.delito.repository.GeolocalizacionRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/geolocalizacion")
public class GeolocalizacionController {

    @Autowired
    private GeolocalizacionRepository geoRepo;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Geolocalizacion geo) {
        geo.setFechaHora(LocalDateTime.now());
        geoRepo.save(geo);
        return ResponseEntity.ok("Ubicación guardada correctamente");
    }
}
