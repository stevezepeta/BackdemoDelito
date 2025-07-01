package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.model.Pregunta;
import prevencion.delito.service.PreguntaService;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @GetMapping
    public List<Pregunta> listar() {
        return preguntaService.listar();
    }

    @PostMapping
    public Pregunta guardar(@RequestBody Pregunta pregunta) {
        return preguntaService.guardar(pregunta);
    }
} 
