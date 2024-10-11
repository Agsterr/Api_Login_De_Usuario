package br.com.agtsoftware.api.service;

import br.com.agtsoftware.api.dto.dtoUsuario.AtualizarUsuarioDto;
import br.com.agtsoftware.api.dto.dtoUsuario.UsuarioCadastroDto;
import br.com.agtsoftware.api.dto.dtoUsuario.UsuarioDto;
import br.com.agtsoftware.api.domain.usuario.Usuario;
import br.com.agtsoftware.api.exception.UsuarioExistenteException;
import br.com.agtsoftware.api.repository.UsuarioRepository;
import br.com.agtsoftware.api.validacoes.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario atualizarUsuario(Long id, AtualizarUsuarioDto usuarioAtualizadoDto) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioAtualizadoDto.nome());
            usuario.setCpf(usuarioAtualizadoDto.cpf());
            usuario.setCategoria(usuarioAtualizadoDto.categoria());
            return usuarioRepository.save(usuario);
        } else {
            throw new ValidacaoException("Usuário não encontrado!");
        }
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Usuário não encontrado!"));
    }

    public void deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new ValidacaoException("Usuário não encontrado!");
        }
    }

    public Page<UsuarioDto> listarUsuariosPaginados(Pageable pageable) {
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);
        return usuarios.map(UsuarioDto::new);  // Convertendo para DTO
    }


    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // Instanciando o codificador

    // Método para cadastrar um novo usuário
    public Usuario cadastrarUsuario(UsuarioCadastroDto usuarioCadastroDto) {

        if (usuarioRepository.existsByUsername(usuarioCadastroDto.username())) {
            throw new UsuarioExistenteException("Usuário com o usernamee '" + usuarioCadastroDto.username() + "' já existe.");
        }
        // Criptografar a senha antes de salvar
        String senhaCriptografada = passwordEncoder.encode(usuarioCadastroDto.password());

        // Conversão do DTO para entidade
        Usuario usuario = Usuario.builder()
                .nome(usuarioCadastroDto.nome())
                .cpf(usuarioCadastroDto.cpf())
                .username(usuarioCadastroDto.username())
                .password(senhaCriptografada)  // Salvando a senha criptografada
                .categoria(usuarioCadastroDto.categoria())
                .build();

        // Salvando no banco de dados
        return usuarioRepository.save(usuario);
    }
}

