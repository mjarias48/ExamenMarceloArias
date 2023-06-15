package ec.edu.espe.arquitectura.examen.seg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.seg.model.SegUsuario;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuarioPerfil;
import ec.edu.espe.arquitectura.examen.seg.repository.SegUsuarioPerfilRepository;
import ec.edu.espe.arquitectura.examen.seg.repository.SegUsuarioRepository;

@Service
public class SegUsuarioService {

    private final SegUsuarioRepository segUsuarioRepository;
    private final SegUsuarioPerfilRepository segUsuarioPerfilRepository;

    public SegUsuarioService(SegUsuarioRepository segUsuarioRepository,
            SegUsuarioPerfilRepository segUsuarioPerfilRepository) {
        this.segUsuarioRepository = segUsuarioRepository;
        this.segUsuarioPerfilRepository = segUsuarioPerfilRepository;
    }

    public void crearUsuario(SegUsuario usuario) {
        Optional<SegUsuario> optional = this.segUsuarioRepository.findByEmail(usuario.getEmail());
        if (optional.isPresent()) {
            throw new RuntimeException("Ya existe un usuario con este email");
        }
        this.segUsuarioRepository.save(usuario);
    }

    public List<SegUsuario> listarUsuarios(String codPerfil) {
        List<SegUsuarioPerfil> segUsuarioPerfiles = this.segUsuarioPerfilRepository.findByPkCodPerfil(codPerfil);
        List<SegUsuario> segUsuarios = new ArrayList<SegUsuario>();
        segUsuarioPerfiles.forEach(segUsuarioPerfil -> {
            segUsuarios.add(segUsuarioPerfil.getSegUsuario());
        });
        return segUsuarios;
    }

}
