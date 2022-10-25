package web.api.app.rest.controller;

import io.swagger.annotations.*;
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
@Api("Cliente")
public class ClienteController {

    private Clientes clientes;

    @ApiOperation("Obter dados do cliente")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cliente encontrado"),
            @ApiResponse(code = 404, message = "Cliente não encontrado")
    })
    @GetMapping(value = "/{cod}")
    public Cliente getClienteById(@PathVariable("cod") @ApiParam("Id do cliente") Integer id) {
        return clientes
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Deletar cliente")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Cliente deletado"),
            @ApiResponse(code = 404, message = "Cliente não encontrado")
    })
    @DeleteMapping(value = "/{cod}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClienteById(@PathVariable("cod") @ApiParam("Id do cliente") Integer id) {
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

    @ApiOperation("Salvar cliente")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Cliente salvo")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid @ApiParam("Dados do cliente") Cliente cliente) {
        return clientes.save(cliente);
    }

    @PutMapping(value = "/{cod}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateClienteById
            (
                    @PathVariable("cod") @ApiParam("Id do cliente") Integer id,
                    @RequestBody @ApiParam("Dadod do cliente") Cliente cliente
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

    @ApiOperation("Buscar cliente pelo filtro")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Clientes encontrados"),
            @ApiResponse(code = 404, message = "Cliente não encontrado")
    })
    @GetMapping
    public List<Cliente> findFilter(@ApiParam("Dadoss do cliente") Cliente filtro) {
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