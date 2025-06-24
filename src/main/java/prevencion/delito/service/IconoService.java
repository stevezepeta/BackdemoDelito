package prevencion.delito.service;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import prevencion.delito.model.Icono;
import prevencion.delito.repository.IconoRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Service
public class IconoService {

    @Value("${iconos.upload-dir}")
    private String rutaBase;

    private final IconoRepository iconoRepository;

    public IconoService(IconoRepository iconoRepository) {
        this.iconoRepository = iconoRepository;
    }

    public List<Icono> obtenerTodos() {
        return iconoRepository.findAll();
    }

    public Icono guardar(MultipartFile file, String nombre) throws IOException {
        // 1. Borrar archivo anterior (si existe uno)
        Icono existente = iconoRepository.findTopByOrderByIdDesc();
        if (existente != null) {
            Path anterior = Paths.get(rutaBase, "ic_launcher.png");
            Files.deleteIfExists(anterior);
        }

        // 2. Guardar y redimensionar el nuevo
        String nombreArchivo = "ic_launcher.png";
        Path destino = Paths.get(rutaBase, nombreArchivo);
        Files.createDirectories(destino.getParent());

        // Redimensionar a 192x192 (ajustable según Flutter)
        Thumbnails.of(file.getInputStream())
                .size(192, 192)
                .outputFormat("png")
                .toFile(destino.toFile());

        // 3. Guardar en base de datos
        Icono icono = new Icono();
        icono.setNombre(nombre);
        icono.setUrl("/assets/icono/" + nombreArchivo); // ruta lógica
        return iconoRepository.save(icono);
    }
}
