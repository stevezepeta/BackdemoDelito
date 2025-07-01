package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prevencion.delito.dto.RespuestaRequestDTO;
import prevencion.delito.model.Respuesta;
import prevencion.delito.service.RespuestaService;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuesta> listar() {
        return respuestaService.listar();
    }

   
        @PostMapping
    public ResponseEntity<?> guardarRespuestas(@RequestBody RespuestaRequestDTO dto) {
        respuestaService.guardarRespuestas(dto);
        return ResponseEntity.ok().build();
    }
} 
