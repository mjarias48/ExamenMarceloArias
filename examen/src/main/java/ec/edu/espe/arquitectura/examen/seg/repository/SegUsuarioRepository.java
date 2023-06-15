package ec.edu.espe.arquitectura.examen.seg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.examen.seg.model.SegUsuario;

@Repository
public interface SegUsuarioRepository extends JpaRepository<SegUsuario, Integer> {
    Optional<SegUsuario> findByEmail(String email);
}
