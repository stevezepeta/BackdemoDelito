package prevencion.delito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prevencion.delito.model.Opcion;
import prevencion.delito.repository.OpcionRepository;

import java.util.List;

@Service
public class OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    public List<Opcion> listar() {
        return opcionRepository.findByActivoTrue();
    }

    public Opcion guardar(Opcion opcion) {
        return opcionRepository.save(opcion);
    }

    public List<Opcion> getByPreguntaId(Long preguntaId) {
        return opcionRepository.findByPreguntaIdAndActivoTrue(preguntaId);
    }

    public void delete(Long id) {
        Opcion opcion = opcionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Opción no encontrada"));
        opcion.setActivo(false);
        opcionRepository.save(opcion);
    }
}
