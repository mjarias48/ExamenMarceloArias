package ec.edu.espe.arquitectura.examen.seg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.examen.seg.model.SegUsuarioPerfil;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuarioPerfilPk;

@Repository
public interface SegUsuarioPerfilRepository extends JpaRepository<SegUsuarioPerfil, SegUsuarioPerfilPk> {

    List<SegUsuarioPerfil> findByPkCodPerfil(String codigoPerfil);
}
