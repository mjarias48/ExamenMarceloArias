package ec.edu.espe.arquitectura.examen.seg.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SEG_PERFIL")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SegPerfil implements Serializable {
    @Id
    @Column(name = "COD_PERFIL", length = 8, nullable = false)
    private Integer codPerfil;
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "segPerfil")
    private List<SegUsuarioPerfil> segUsuarioPerfil;

    @Version
    private Integer version;
}
