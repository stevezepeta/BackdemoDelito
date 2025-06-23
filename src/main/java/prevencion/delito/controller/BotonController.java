package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.model.Boton;
import prevencion.delito.service.BotonService;

import java.util.List;

@RestController
@RequestMapping("/api/botones")
public class BotonController {

    @Autowired
    private BotonService botonService;

    @GetMapping
    public List<Boton> listar() {
        return botonService.listarTodos();
    }

    @PostMapping
    public Boton crear(@RequestBody Boton boton) {
        return botonService.guardar(boton);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        botonService.eliminar(id);
    }
}
