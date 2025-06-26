package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.model.TextoDinamico;
import prevencion.delito.service.TextoDinamicoService;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/textos")
public class TextoDinamicoController {

    @Autowired
    private TextoDinamicoService textoService;

    @GetMapping
    public List<TextoDinamico> obtenerTodos() {
        return textoService.obtenerTodos();
    }

@PostMapping
public TextoDinamico guardar(@RequestBody TextoDinamico texto) {
    return textoService.guardar(texto);
}


    @GetMapping("/{clave}")
    public TextoDinamico obtenerPorClave(@PathVariable String clave) {
        return textoService.obtenerPorClave(clave).orElse(null);
    }
}
