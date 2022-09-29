package web.api.app.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import web.api.app.domain.entity.Cliente;
import web.api.app.domain.entity.Produto;
import web.api.app.domain.repository.Produtos;

import java.util.List;


@RestController
@RequestMapping(value = "/api/produtos")
@AllArgsConstructor
public class ProdutoController {

    private Produtos produtos;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto getProdutoById(@PathVariable("id") Integer id) {
        return produtos
                .findById(id)
                .map(cli -> cli)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody Produto produto) {
        return produtos.save(produto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProdutoById(@PathVariable("id") Integer id) {
        produtos
                .findById(id)
                .map((prod) -> {
                    produtos.delete(prod);
                    return prod;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProdutoById
            (
                    @PathVariable("id") Integer id,
                    @RequestBody Produto produto
            ) {
        produtos
                .findById(id)
                .map((prod) -> {
                    produtos.updateById(id, produto.getDescricao(), produto.getPreco());
                    return prod;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Produto> findFilter(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Produto> lista = produtos.findAll(example);

        if (!lista.isEmpty()) {
            return lista;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
