package prevencion.delito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prevencion.delito.model.Boton;
import prevencion.delito.repository.BotonRepository;

import java.util.List;

@Service
public class BotonService {

    @Autowired
    private BotonRepository botonRepository;

    public List<Boton> listarTodos() {
        return botonRepository.findAll();
    }

    public Boton guardar(Boton boton) {
        return botonRepository.save(boton);
    }

    public void eliminar(Long id) {
        botonRepository.deleteById(id);
    }
}
