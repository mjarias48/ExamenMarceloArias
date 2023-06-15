package ec.edu.espe.arquitectura.examen.seg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.examen.seg.model.SegPerfil;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuario;

@Repository
public interface SegPerfilRepository extends JpaRepository<SegUsuario, Integer> {

    public List<SegPerfil> findAllOrderByNombre();
}
