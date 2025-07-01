package prevencion.delito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prevencion.delito.model.Pregunta;
import prevencion.delito.repository.PreguntaRepository;

import java.util.List;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    public List<Pregunta> listar() {
        return preguntaRepository.findByActivoTrue(); // Método personalizado
    }

    public Pregunta guardar(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public void eliminar(Long id) {
        Pregunta pregunta = preguntaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
        pregunta.setActivo(false); // Ocultar
        preguntaRepository.save(pregunta);
    }
}
