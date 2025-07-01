package prevencion.delito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prevencion.delito.model.Encuesta;
import prevencion.delito.repository.EncuestaRepository;

import java.util.List;

@Service
public class EncuestaService {

    @Autowired
    private EncuestaRepository encuestaRepository;

    public List<Encuesta> getAll() {
        return encuestaRepository.findAll();
    }

    public Encuesta save(Encuesta encuesta) {
        return encuestaRepository.save(encuesta);
    }

    public Encuesta findById(Long id) {
        return encuestaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encuesta no encontrada con ID: " + id));
    }

    public void delete(Long id) {
        encuestaRepository.deleteById(id);
    }
    public List<Encuesta> findByPantalla(String pantalla) {
    return encuestaRepository.findByPantallaAndActivoTrue(pantalla);
}

}
