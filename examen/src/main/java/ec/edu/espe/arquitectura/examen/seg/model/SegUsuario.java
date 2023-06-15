package ec.edu.espe.arquitectura.examen.seg.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "SEG_USUARIO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SegUsuario implements Serializable{

    @Id
    @Column(name = "COD_USUARIO", nullable = false)
    private Integer codUsuario;
    @Column(name = "EMAIL", length = 128, nullable = false)
    private String email;
    @Column(name = "CLAVE", length = 64, nullable = false)
    private String clave;
    @Column(name = "NOMBRE", length = 128, nullable = false)
    private String nombre;
    @Column(name = "INTENTOS_FALLIDOS", scale = 8, nullable = false)
    private Integer intentosFallidos;
    @Column(name = "SUELDO", scale = 8, precision = 2,  nullable = false)
    private BigDecimal sueldo;
    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private Date fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private List<SegUsuarioPerfil> segUsuarioPerfil;

    @Version
    private Integer version;
}
