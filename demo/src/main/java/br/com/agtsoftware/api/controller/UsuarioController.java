package br.com.agtsoftware.api.controller;

import br.com.agtsoftware.api.dto.dtoUsuario.AtualizarUsuarioDto;
import br.com.agtsoftware.api.dto.dtoUsuario.UsuarioCadastroDto;
import br.com.agtsoftware.api.dto.dtoUsuario.UsuarioDto;
import br.com.agtsoftware.api.domain.usuario.Usuario;
import br.com.agtsoftware.api.exception.UsuarioExistenteException;
import br.com.agtsoftware.api.repository.UsuarioRepository;
import br.com.agtsoftware.api.service.UsuarioService;
import br.com.agtsoftware.api.validacoes.ValidacaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    // Método para cadastrar um novo usuário


    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizarUsuario(@PathVariable Long id, @RequestBody AtualizarUsuarioDto usuarioAtualizadoDto) {
        try {
            Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioAtualizadoDto);
            return ResponseEntity.ok(new UsuarioDto(usuarioAtualizado));
        } catch (ValidacaoException exception) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> buscarUsuarioPorId(@PathVariable Long id) {
        try {
            Usuario usuario = usuarioService.buscarUsuarioPorId(id);
            return ResponseEntity.ok(new UsuarioDto(usuario));
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (ValidacaoException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioDto>> listarUsuariosPaginados(@RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size) {
        Page<UsuarioDto> usuarios = usuarioService.listarUsuariosPaginados(PageRequest.of(page, size));
        return ResponseEntity.ok(usuarios);
    }

    // Método para cadastrar um novo usuário
    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioCadastroDto usuarioCadastroDto) {

        try {
            Usuario usuario = usuarioService.cadastrarUsuario(usuarioCadastroDto);
            return ResponseEntity.ok(new UsuarioDto(usuario));  // Converte a entidade para DTO e retorna
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().build();  // Retorna erro 400 se houver algum problema
        }
    }

}

