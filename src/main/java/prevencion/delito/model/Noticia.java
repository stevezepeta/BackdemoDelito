package prevencion.delito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob // para permitir texto largo
    private String texto;

    private String imagenUrl; // puedes cambiarlo si vas a subir archivos

    private Float posicionX;
    private Float posicionY;
}
