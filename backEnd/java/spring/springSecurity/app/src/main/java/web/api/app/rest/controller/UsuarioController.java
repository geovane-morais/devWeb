package web.api.app.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.api.app.domain.entity.Usuario;
import web.api.app.service.impl.UserServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UserServiceImpl userServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@Valid @RequestBody Usuario usuario){
        return userServiceImpl.salvar(usuario);
    }
}
