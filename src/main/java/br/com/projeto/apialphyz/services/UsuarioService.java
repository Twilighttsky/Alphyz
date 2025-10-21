package br.com.projeto.apialphyz.services;

import br.com.projeto.apialphyz.dto.RegistroDTO;
import br.com.projeto.apialphyz.model.Usuario;
import br.com.projeto.apialphyz.repository.UsuarioRepository;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    // Construtor para injeção de dependências
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }

    public Usuario registrarNovoUsuario(RegistroDTO registroDTO) {

        // Verifica se o email ou CPF já estão no sistema
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            throw new RuntimeException("Esse email já está cadastrado.");
        } else if (usuarioRepository.existsByCpf(registroDTO.getCpf())) {
            throw new RuntimeException("Esse CPF já está cadastrado.");
        }



        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(registroDTO.getNome());
        novoUsuario.setEmail(registroDTO.getEmail());
        novoUsuario.setCpf(registroDTO.getCpf());
        novoUsuario.setTelefone(registroDTO.getTelefone());
        novoUsuario.setIdade(registroDTO.getIdade());
        novoUsuario.setSenha(registroDTO.getSenha());
        novoUsuario.setCep(registroDTO.getCep());
        novoUsuario.setCidade(registroDTO.getCidade());
        novoUsuario.setEstado(registroDTO.getEstado());
        novoUsuario.setRua(registroDTO.getRua());
        novoUsuario.setComplemento(registroDTO.getComplemento());
        novoUsuario.setNumero(registroDTO.getNumero());


        //Criptografa a senha antes de salvar
       // String senhaCriptografada = passwordEncoder.encode(registroDTO.getSenha());
       // novoUsuario.setSenha(senhaCriptografada);

        // novoUsuario.setRoles(Set.of(roleRepository.findByName("ROLE_USER")));

        return usuarioRepository.save(novoUsuario);
    }
}
