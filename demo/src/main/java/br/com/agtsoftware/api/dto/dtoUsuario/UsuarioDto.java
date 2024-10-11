package br.com.agtsoftware.api.dto.dtoUsuario;

import br.com.agtsoftware.api.domain.usuario.Usuario;
import br.com.agtsoftware.api.enuns.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private String nome;
    private String cpf;
    private Categoria categoria;
    private String username;  // Campo para login
    private String password;  // Campo para senha

    public UsuarioDto(Usuario usuario) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.categoria = usuario.getCategoria();
        this.username = usuario.getUsername();
        this.password = usuario.getPassword(); // Senha já criptografada
    }
}
