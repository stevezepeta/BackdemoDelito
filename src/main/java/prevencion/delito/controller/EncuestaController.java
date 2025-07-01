package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import prevencion.delito.dto.EncuestaResponseDTO;
import prevencion.delito.dto.OpcionDTO;
import prevencion.delito.dto.PreguntaDTO;
import prevencion.delito.model.Encuesta;
import prevencion.delito.service.EncuestaService;

import java.util.List;

@RestController
@RequestMapping("/api/encuestas")
public class EncuestaController {

    @Autowired
    private EncuestaService encuestaService;

    @GetMapping("/{id}")
    public EncuestaResponseDTO obtenerEncuesta(@PathVariable Long id) {
        Encuesta encuesta = encuestaService.findById(id);
        EncuestaResponseDTO dto = new EncuestaResponseDTO();
        dto.id = encuesta.getId();
        dto.titulo = encuesta.getTitulo();

        dto.preguntas = encuesta.getPreguntas().stream().map(p -> {
            PreguntaDTO pDto = new PreguntaDTO();
            pDto.id = p.getId();
            pDto.texto = p.getTexto();
            pDto.posX = p.getPosX();
            pDto.posY = p.getPosY();
            pDto.pantalla = p.getPantalla();
            pDto.opciones = p.getOpciones().stream().map(o -> {
                OpcionDTO oDto = new OpcionDTO();
                oDto.id = o.getId();
                oDto.texto = o.getTexto();
                oDto.posX = o.getPosX();
                oDto.posY = o.getPosY();
                return oDto;
            }).toList();
            return pDto;
        }).toList();

        return dto;
    }

    @PostMapping
    public Encuesta crearEncuesta(@RequestBody Encuesta encuesta) {
        return encuestaService.save(encuesta);
    }

    @GetMapping
public List<EncuestaResponseDTO> obtenerEncuestasPorPantalla(@RequestParam String pantalla) {
    List<Encuesta> encuestas = encuestaService.findByPantalla(pantalla);

    return encuestas.stream().map(encuesta -> {
        EncuestaResponseDTO dto = new EncuestaResponseDTO();
        dto.id = encuesta.getId();
        dto.titulo = encuesta.getTitulo();
        dto.preguntas = encuesta.getPreguntas().stream().map(p -> {
            PreguntaDTO pDto = new PreguntaDTO();
            pDto.id = p.getId();
            pDto.texto = p.getTexto();
            pDto.posX = p.getPosX();
            pDto.posY = p.getPosY();
            pDto.pantalla = p.getPantalla();
            pDto.opciones = p.getOpciones().stream().map(o -> {
                OpcionDTO oDto = new OpcionDTO();
                oDto.id = o.getId();
                oDto.texto = o.getTexto();
                oDto.posX = o.getPosX();
                oDto.posY = o.getPosY();
                return oDto;
            }).toList();
            return pDto;
        }).toList();
        return dto;
    }).toList();
}

}
