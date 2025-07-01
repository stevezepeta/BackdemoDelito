package prevencion.delito.dto;

import java.util.List;

public class PreguntaDTO {
    public Long id;
    public String texto;
    public Double posX;
    public Double posY;
    public String pantalla;
    public List<OpcionDTO> opciones;
}