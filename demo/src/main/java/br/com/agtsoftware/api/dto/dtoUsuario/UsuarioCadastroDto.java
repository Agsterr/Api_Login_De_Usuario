package br.com.agtsoftware.api.dto.dtoUsuario;

import br.com.agtsoftware.api.enuns.Categoria;

public record UsuarioCadastroDto(String username, String password, String cpf , String nome, Categoria categoria) {
}
