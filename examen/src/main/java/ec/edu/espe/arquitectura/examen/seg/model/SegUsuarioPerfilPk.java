package ec.edu.espe.arquitectura.examen.seg.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SegUsuarioPerfilPk implements Serializable {

    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codUsuario;
    @Column(name = "COD_PERFIL", length = 128, nullable = false)
    private String codPerfil;
}
