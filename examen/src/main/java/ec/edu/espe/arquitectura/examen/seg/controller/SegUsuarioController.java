package ec.edu.espe.arquitectura.examen.seg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examen.seg.model.SegPerfil;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuario;
import ec.edu.espe.arquitectura.examen.seg.model.SegUsuarioPerfil;
import ec.edu.espe.arquitectura.examen.seg.service.SegUsuarioService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/usuarios")
public class SegUsuarioController {

    private SegUsuarioService segUsuarioService;

    public SegUsuarioController(SegUsuarioService segUsuarioService) {
        this.segUsuarioService = segUsuarioService;
    }

    @PostMapping("/")
    public ResponseEntity crearUsuario(@RequestBody SegUsuario usuario) {
        try {
            this.segUsuarioService.crearUsuario(usuario);
            return ResponseEntity.created(null).build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/perfil/{codPerfil}")
    public ResponseEntity<List<SegUsuario>> listarUsuarios(@PathParam("codPerfil") String codPerfil) {
        try {
            List<SegUsuario> usuarios = this.segUsuarioService.listarUsuarios(codPerfil);
            return ResponseEntity.ok(usuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
