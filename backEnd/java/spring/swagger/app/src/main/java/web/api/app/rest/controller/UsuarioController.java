package web.api.app.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web.api.app.domain.entity.Usuario;
import web.api.app.exception.SenhaInvalidaException;
import web.api.app.rest.dto.CredenciasDTO;
import web.api.app.rest.dto.TokenDTO;
import web.api.app.security.jwt.JwtService;
import web.api.app.service.impl.UserServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UserServiceImpl userServiceImpl;
    private final JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@Valid @RequestBody Usuario usuario){
        return userServiceImpl.salvar(usuario);
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public TokenDTO autenticar(@Valid @RequestBody CredenciasDTO credencias){
        try{
            Usuario usuario = new Usuario();
            usuario.setPass(credencias.getPassword());
            usuario.setLogin(credencias.getLogin());
            UserDetails usuarioAutenticado = userServiceImpl.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getLogin(), token);
        }catch (SenhaInvalidaException | UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
