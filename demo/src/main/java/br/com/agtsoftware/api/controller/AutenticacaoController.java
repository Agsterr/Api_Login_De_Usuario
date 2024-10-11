package br.com.agtsoftware.api.controller;

import br.com.agtsoftware.api.domain.usuario.Usuario;
import br.com.agtsoftware.api.dto.DadosAutenticacaoDto;
import br.com.agtsoftware.api.dto.dtoUsuario.DadosTokenJWT;
import br.com.agtsoftware.api.token.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {



    // classe responsavel por fazer a autenticação
    //mas ela não injeta sozinha tem que ensinar ela veja na classe securityConfiguration
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados){
        var Authenticationtoken = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var authentication = manager.authenticate(Authenticationtoken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        //antes dessa alteração o token veio solto depois do dto ele vem em um json com nome token
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));


    }
}
