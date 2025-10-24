package br.com.projeto.apialphyz.controller;

import br.com.projeto.apialphyz.dto.RegistroUsuarioDTO;
import br.com.projeto.apialphyz.model.Usuario;
import br.com.projeto.apialphyz.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticar")
public class RegistroController {

    private final UsuarioService usuarioService;
    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroUsuarioDTO registroUsuarioDTO) {
        try {
            Usuario novoUsuario = usuarioService.registrarNovoUsuario(registroUsuarioDTO);

            // Retorna um status 201 Created (ou 200 OK com uma mensagem de sucesso)
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso!");

        } catch (RuntimeException e) {
            // Retorna 400 Bad Request se o email já estiver em uso
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
