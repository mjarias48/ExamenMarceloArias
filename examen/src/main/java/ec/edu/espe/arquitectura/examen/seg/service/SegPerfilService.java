package ec.edu.espe.arquitectura.examen.seg.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.seg.model.SegPerfil;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuarioPerfil;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuarioPerfilPk;
import ec.edu.espe.arquitectura.examen.seg.repository.SegPerfilRepository;
import ec.edu.espe.arquitectura.examen.seg.repository.SegUsuarioPerfilRepository;

@Service
public class SegPerfilService {

    private final SegPerfilRepository segPerfilRepository;
    private final SegUsuarioPerfilRepository segUsuarioPerfil;

    public SegPerfilService(SegPerfilRepository segPerfilRepository, SegUsuarioPerfilRepository segUsuarioPerfil) {
        this.segPerfilRepository = segPerfilRepository;
        this.segUsuarioPerfil = segUsuarioPerfil;
    }

    public List<SegPerfil> listarPerfiles() {
        return this.segPerfilRepository.findAllOrderByNombre();
    }

    public void asignarPerfil(Integer codUsuario, String codPerfil) {
        SegUsuarioPerfil associate = new SegUsuarioPerfil();
        associate.setPK(new SegUsuarioPerfilPk(codUsuario, codPerfil));
        associate.setEsActivo(true);
        associate.setFechaCreacion(new Date());
        associate.setVersion(1);

        try {
            this.segUsuarioPerfil.save(associate);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
