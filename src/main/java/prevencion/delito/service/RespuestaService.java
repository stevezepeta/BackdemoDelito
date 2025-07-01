package prevencion.delito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prevencion.delito.dto.ItemRespuestaDTO;
import prevencion.delito.dto.RespuestaRequestDTO;
import prevencion.delito.model.Opcion;
import prevencion.delito.model.Pregunta;
import prevencion.delito.model.Respuesta;
import prevencion.delito.repository.OpcionRepository;
import prevencion.delito.repository.PreguntaRepository;
import prevencion.delito.repository.RespuestaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {
@Autowired
private PreguntaRepository preguntaRepository;

@Autowired
private OpcionRepository opcionRepository;



    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta guardar(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> listar() {
        return respuestaRepository.findAll();
    }
    public void guardarRespuestas(RespuestaRequestDTO request) {
    for (ItemRespuestaDTO item : request.getRespuestas()) {

        Optional<Pregunta> preguntaOpt = preguntaRepository.findById(item.getPreguntaId());
        if (preguntaOpt.isEmpty()) {
            throw new IllegalArgumentException("Pregunta ID no válido: " + item.getPreguntaId());
        }

        Optional<Opcion> opcionOpt = opcionRepository.findById(item.getOpcionId());
        if (opcionOpt.isEmpty()) {
            throw new IllegalArgumentException("Opción ID no válida: " + item.getOpcionId());
        }

        // Aquí va tu lógica para guardar la respuesta:
     Respuesta r = new Respuesta();
r.setEncuestaId(request.getEncuestaId());
r.setDispositivoId(request.getDispositivoId());
r.setPreguntaId(item.getPreguntaId()); // <-- directamente el ID
r.setOpcionId(item.getOpcionId());     // <-- directamente el ID


        respuestaRepository.save(r);
    }
}
}
