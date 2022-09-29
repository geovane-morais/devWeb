package web.api.app.rest.controller;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web.api.app.domain.entity.Cliente;
import web.api.app.domain.repository.Clientes;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController
    {
        private Clientes clientes;
        public ClienteController (Clientes clientes)
            {
                this.clientes = clientes;
            }

        @GetMapping(value = "/{cod}")
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public Cliente getClienteById(@PathVariable("cod") Integer id)
            {
                return clientes
                        .findById(id)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
            }

        @DeleteMapping(value = "/{cod}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteCliente(@PathVariable("cod") Integer id)
            {
                clientes
                        .findById(id)
                        .map((cliente) -> clientes.delete(cliente))
                        .orElseThrow(
                                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
                        );
            }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Cliente save(@RequestBody Cliente cliente)
            {
                return clientes.save(cliente);
            }

        @PutMapping(value = "/{cod}")
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public void updateClienteById
                (
                    @PathVariable("cod") Integer id,
                    @RequestBody Cliente cliente
                )
            {
                clientes
                        .findById(id)
                        .map(clienteUpdate -> clientes.updateById(id, clienteUpdate.getNome()))
                        .orElseThrow(
                                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
                        );
            }

        @GetMapping
        public List<Cliente> find(Cliente filtro){
            ExampleMatcher matcher = ExampleMatcher
                                        .matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

            Example example = Example.of(filtro, matcher);
            return clientes.findAll(example);
        }
    }