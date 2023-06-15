package ec.edu.espe.arquitectura.examen.seg.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@Data
@Builder
@Entity
@Table(name = "SEG_USUARIO_PERFIL")
@AllArgsConstructor
@NoArgsConstructor
public class SegUsuarioPerfil implements Serializable {

    @EmbeddedId
    @Include
    private SegUsuarioPerfilPk PK;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;
    @Column(name = "ES_ACTIVO", nullable = false)
    private Boolean esActivo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
    private SegUsuario segUsuario;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", insertable = false, updatable = false)
    private SegPerfil segPerfil;

    @Version
    private Integer version;
}
