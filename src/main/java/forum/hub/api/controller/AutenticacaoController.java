package forum.hub.api.controller;


import forum.hub.api.domain.usuarios.DadosAutenticacao;
import forum.hub.api.domain.usuarios.Usuario;
import forum.hub.api.infra.security.TokenService;
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

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
       var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

        var authentication =  manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));

    }
}
