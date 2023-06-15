package ec.edu.espe.arquitectura.examen.seg.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.seg.model.SegPerfil;
import ec.edu.espe.arquitectura.examen.seg.service.SegPerfilService;

@RestController
@RequestMapping("/perfiles")
public class SegPerfilController {

    private final SegPerfilService segPerfilService;

    public SegPerfilController(SegPerfilService segPerfilService) {
        this.segPerfilService = segPerfilService;
    }

    @GetMapping("/")
    public ResponseEntity<List<SegPerfil>> listarPerfiles() {
        try {
            List<SegPerfil> perfiles = this.segPerfilService.listarPerfiles();
            return ResponseEntity.ok(perfiles);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity asignarPerfil(@RequestBody PerfilUsuarioDTO dto) {
        try {
            this.segPerfilService.asignarPerfil(dto.codUsuario, dto.codPerfil);
            return ResponseEntity.created(null).build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    class PerfilUsuarioDTO implements Serializable {
        private Integer codUsuario;
        private String codPerfil;
    }

}
