package prevencion.delito.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "botones")
public class Boton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private String colorHex;
    private String ruta;

    private Double posX;
    private Double posY;

    private String pantalla; // 🔑 Nueva propiedad para indicar la pestaña

    
}
