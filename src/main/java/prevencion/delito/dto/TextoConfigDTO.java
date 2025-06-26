package prevencion.delito.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TextoConfigDTO {
    private Long id;
    private String clave;
    private String valor;
    private Double posX;
    private Double posY;
}
