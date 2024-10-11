package br.com.agtsoftware.api.dto.dtoUsuario;

import br.com.agtsoftware.api.enuns.Categoria;

public record CriarUsuarioDto(String nome, String cpf, Categoria categoria) {
}
