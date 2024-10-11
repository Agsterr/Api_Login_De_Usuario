package br.com.agtsoftware.api.domain.usuario;

import br.com.agtsoftware.api.enuns.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// IMPLEMENTAÇÃO PARA O SPRING SECURITY RECONHECER O USUARIO
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private Categoria categoria;

    // Campo para o nome de usuário (deve ser único)
    @Column(nullable = false, unique = true)
    private String username;

    // Campo para a senha criptografada
    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + categoria.name()));
    }


    @Override
    public boolean isAccountNonExpired() {
        return true; // Você pode implementar lógica adicional se quiser bloquear contas expiradas
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Ou você pode criar um campo para gerenciar o bloqueio de contas
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Aqui também pode ser adicionada lógica para verificar se as credenciais estão expiradas
    }

    @Override
    public boolean isEnabled() {
        return true; // Pode haver um campo "ativo" no banco de dados para controlar isso
    }
}