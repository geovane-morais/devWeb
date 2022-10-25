package web.api.app.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web.api.app.domain.entity.Cliente;
import web.api.app.domain.repository.Clientes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private Clientes clientes;

    @GetMapping(value = "/{cod}")
    public Cliente getClienteById(@PathVariable("cod") Integer id) {
        return clientes
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/{cod}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClienteById(@PathVariable("cod") Integer id) {
        clientes
                .findById(id)
                .map((cli) -> {
                    clientes.delete(cli);
                    return cli;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return clientes.save(cliente);
    }

    @PutMapping(value = "/{cod}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateClienteById
            (
                    @PathVariable("cod") Integer id,
                    @RequestBody Cliente cliente
            ) {
        clientes
                .findById(id)
                .map((cli) -> {
                    clientes.updateById(id, cliente.getNome());
                    return cli;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @GetMapping
    public List<Cliente> findFilter(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);

        if (!lista.isEmpty()) {
            return lista;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}