package prevencion.delito.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ui_components")
public class UiComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // Ej: "button", "icon", "text"

    @Column(columnDefinition = "TEXT")
    private String propertiesJson; // JSON serializado con las propiedades del componente

    private LocalDateTime lastUpdated;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertiesJson() {
        return propertiesJson;
    }

    public void setPropertiesJson(String propertiesJson) {
        this.propertiesJson = propertiesJson;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
