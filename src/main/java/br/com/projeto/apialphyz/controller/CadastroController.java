package br.com.projeto.apialphyz.controller;

import br.com.projeto.apialphyz.dto.CadastroUsuarioDTO;
import br.com.projeto.apialphyz.model.Usuario;
import br.com.projeto.apialphyz.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/autenticar")
public class CadastroController {


    private final UsuarioService usuarioService;
    public CadastroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody CadastroUsuarioDTO cadastroUsuarioDTO) {
        try {
            Usuario novoUsuario = usuarioService.cadastrarNovoUsuario(cadastroUsuarioDTO);

            // Retorna um status 201 Created (ou 200 OK com uma mensagem de sucesso)
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso!");

        } catch (RuntimeException e) {
            // Retorna 400 Bad Request se o email já estiver em uso
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
