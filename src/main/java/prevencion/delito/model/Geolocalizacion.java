package prevencion.delito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Geolocalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHora;

    private String dispositivoId;

    private Long usuarioId;

    // Puedes agregar referencia si va ligada a una respuesta, por ejemplo:
    // @OneToOne o @ManyToOne con @JoinColumn si aplica
}
