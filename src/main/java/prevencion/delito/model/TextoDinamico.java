package prevencion.delito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TextoDinamico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clave;
    private String valor;

    private Double posX; // Porcentaje horizontal (0.0 a 1.0)
    private Double posY; // Porcentaje vertical (0.0 a 1.0)
    private String pantalla; // 👈 "home", "configuracion", etc.
}
