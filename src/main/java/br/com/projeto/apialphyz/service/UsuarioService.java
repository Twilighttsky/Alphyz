package br.com.projeto.apialphyz.service;

import br.com.projeto.apialphyz.dto.RegistroUsuarioDTO;
import br.com.projeto.apialphyz.model.Usuario;
import br.com.projeto.apialphyz.repository.UsuarioRepository;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    // Construtor para injeção de dependências
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }

    public Usuario registrarNovoUsuario(RegistroUsuarioDTO registroUsuarioDTO) {

        // Verifica se o email ou CPF já estão no sistema
        if (usuarioRepository.existsByEmail(registroUsuarioDTO.getEmail())) {
            throw new RuntimeException("Esse email já está cadastrado.");
        } else if (usuarioRepository.existsByCpf(registroUsuarioDTO.getCpf())) {
            throw new RuntimeException("Esse CPF já está cadastrado.");
        }



        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(registroUsuarioDTO.getNome());
        novoUsuario.setEmail(registroUsuarioDTO.getEmail());
        novoUsuario.setCpf(registroUsuarioDTO.getCpf());
        novoUsuario.setTelefone(registroUsuarioDTO.getTelefone());
        novoUsuario.setIdade(registroUsuarioDTO.getIdade());
        novoUsuario.setSenha(registroUsuarioDTO.getSenha());
        novoUsuario.setCep(registroUsuarioDTO.getCep());
        novoUsuario.setCidade(registroUsuarioDTO.getCidade());
        novoUsuario.setEstado(registroUsuarioDTO.getEstado());
        novoUsuario.setRua(registroUsuarioDTO.getRua());
        novoUsuario.setComplemento(registroUsuarioDTO.getComplemento());
        novoUsuario.setNumero(registroUsuarioDTO.getNumero());


        //Criptografa a senha antes de salvar
       // String senhaCriptografada = passwordEncoder.encode(registroDTO.getSenha());
       // novoUsuario.setSenha(senhaCriptografada);

        // novoUsuario.setRoles(Set.of(roleRepository.findByName("ROLE_USER")));

        return usuarioRepository.save(novoUsuario);
    }
}
