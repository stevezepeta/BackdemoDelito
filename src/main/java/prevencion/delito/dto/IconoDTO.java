package prevencion.delito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prevencion.delito.model.Icono;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IconoDTO {
    private String nombre;
    private String url;

    public IconoDTO(Icono icono) {
        this.nombre = icono.getNombre();
        this.url = icono.getUrl();
    }
}
