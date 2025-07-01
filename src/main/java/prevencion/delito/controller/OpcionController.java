package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prevencion.delito.model.Opcion;
import prevencion.delito.service.OpcionService;

import java.util.List;

@RestController
@RequestMapping("/api/opciones")
public class OpcionController {

    @Autowired
    private OpcionService opcionService;

    @GetMapping
    public List<Opcion> listar() {
        return opcionService.listar();
    }

    @PostMapping
    public Opcion guardar(@RequestBody Opcion opcion) {
        return opcionService.guardar(opcion);
    }
} 
