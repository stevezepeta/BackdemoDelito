package prevencion.delito.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long encuestaId;
    private Long preguntaId;
    private Long opcionId;

    private String dispositivoId;

    private Long usuarioId;
}
