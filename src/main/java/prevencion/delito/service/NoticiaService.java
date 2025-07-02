package prevencion.delito.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import prevencion.delito.model.Noticia;
import prevencion.delito.repository.NoticiaRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepo;
    private static final String BASE_DIR = "C:/Users/Windows/Pictures/Prueba de Back/noticias/";

    public NoticiaService(NoticiaRepository noticiaRepo) {
        this.noticiaRepo = noticiaRepo;
    }

    public Noticia crearNoticia(String titulo, String texto, Float x, Float y, MultipartFile imagen) throws Exception {
        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setTexto(texto);
        noticia.setPosicionX(x);
        noticia.setPosicionY(y);
        noticia = noticiaRepo.save(noticia);

        if (imagen != null && !imagen.isEmpty()) {
            String carpeta = BASE_DIR + noticia.getId();
            Files.createDirectories(Paths.get(carpeta));
            String nombre = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            Path ruta = Paths.get(carpeta, nombre);
            imagen.transferTo(ruta.toFile());
            noticia.setImagenUrl(ruta.toString());
            noticiaRepo.save(noticia);
        }

        return noticia;
    }

    public Noticia actualizarNoticia(Long id, String titulo, String texto, Float x, Float y, MultipartFile imagen) throws Exception {
        Noticia noticia = noticiaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Noticia no encontrada"));

        noticia.setTitulo(titulo);
        noticia.setTexto(texto);
        noticia.setPosicionX(x);
        noticia.setPosicionY(y);

        if (imagen != null && !imagen.isEmpty()) {
            String carpeta = BASE_DIR + noticia.getId();
            Files.createDirectories(Paths.get(carpeta));
            String nombre = UUID.randomUUID() + "_" + imagen.getOriginalFilename();
            Path ruta = Paths.get(carpeta, nombre);
            imagen.transferTo(ruta.toFile());
            noticia.setImagenUrl(ruta.toString());
        }

        return noticiaRepo.save(noticia);
    }

    public List<Noticia> listarNoticias() {
        return noticiaRepo.findAll();
    }

    public Optional<Noticia> obtenerNoticia(Long id) {
        return noticiaRepo.findById(id);
    }

    public void eliminarNoticia(Long id) {
        noticiaRepo.deleteById(id);
    }
}
