package prevencion.delito.dto;

import java.util.List;

// RespuestaRequestDTO.java
public class RespuestaRequestDTO {
    private Long encuestaId;
    private String dispositivoId;
    private List<ItemRespuestaDTO> respuestas;

    public Long getEncuestaId() {
        return encuestaId;
    }

    public String getDispositivoId() {
        return dispositivoId;
    }

    public List<ItemRespuestaDTO> getRespuestas() {
        return respuestas;
    }
}

