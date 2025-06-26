package prevencion.delito.service;

import org.springframework.stereotype.Service;
import prevencion.delito.model.TextoDinamico;
import prevencion.delito.repository.TextoDinamicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TextoDinamicoService {
    private final TextoDinamicoRepository repo;

    public TextoDinamicoService(TextoDinamicoRepository repo) {
        this.repo = repo;
    }

    public List<TextoDinamico> obtenerTodos() {
        return repo.findAll();
    }

    public Optional<TextoDinamico> obtenerPorClave(String clave) {
        return repo.findByClave(clave);
    }

    public TextoDinamico guardar(TextoDinamico texto) {
        return repo.save(texto);
    }
}
