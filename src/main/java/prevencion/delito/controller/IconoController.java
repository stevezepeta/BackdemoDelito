package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import prevencion.delito.model.Icono;
import prevencion.delito.service.IconoService;
import prevencion.delito.dto.IconoDTO;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/iconos")
public class IconoController {

    @Autowired
    private IconoService iconoService;

    @Value("${iconos.upload-dir}")
    private String uploadDir;

    @GetMapping
    public List<Icono> obtenerIconos() {
        return iconoService.obtenerTodos();
    }

   @PostMapping
public ResponseEntity<IconoDTO> guardarIcono(
    @RequestParam("nombre") String nombre,
    @RequestParam("file") MultipartFile file
) {
    try {
        Icono guardado = iconoService.guardar(file, nombre);  // 👈 cambio aquí
        return ResponseEntity.ok(new IconoDTO(guardado));
    } catch (IOException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

}
