package prevencion.delito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import prevencion.delito.model.Noticia;
import prevencion.delito.service.NoticiaService;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @PostMapping(value = "/crear", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> crear(
            @RequestParam String titulo,
            @RequestParam String texto,
            @RequestParam Float posicionX,
            @RequestParam Float posicionY,
            @RequestParam MultipartFile imagen
    ) {
        try {
            Noticia noticia = noticiaService.crearNoticia(titulo, texto, posicionX, posicionY, imagen);
            return ResponseEntity.ok(noticia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestParam String titulo,
            @RequestParam String texto,
            @RequestParam Float posicionX,
            @RequestParam Float posicionY,
            @RequestParam(required = false) MultipartFile imagen
    ) {
        try {
            Noticia noticia = noticiaService.actualizarNoticia(id, titulo, texto, posicionX, posicionY, imagen);
            return ResponseEntity.ok(noticia);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Noticia>> listar() {
        return ResponseEntity.ok(noticiaService.listarNoticias());
    }

 @GetMapping("/{id}")
public ResponseEntity<Object> obtenerPorId(@PathVariable Long id) {
    return noticiaService.obtenerNoticia(id)
            .<ResponseEntity<Object>>map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Noticia no encontrada"));
}



    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        noticiaService.eliminarNoticia(id);
        return ResponseEntity.ok("Noticia eliminada");
    }
}
