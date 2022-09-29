package web.api.app.rest.controller;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.api.app.domain.entity.Cliente;
import web.api.app.domain.repository.Clientes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class ClienteController
    {
        private Clientes clientes;
        public ClienteController (Clientes clientes)
            {
                this.clientes = clientes;
            }

        @GetMapping(value = "/clientes/{cod}")
        @ResponseBody
        public ResponseEntity getClienteById(@PathVariable("cod") Integer id)
            {
                Optional<Cliente> cliente = clientes.findById(id);
                if(cliente.isPresent())
                    {
                        return ResponseEntity.ok(cliente.get().toString());
                    }
                return ResponseEntity.notFound().build();
            }

        @DeleteMapping(value = "/clientes/{cod}")
        @ResponseBody
        public ResponseEntity deleteClienteById(@PathVariable("cod") Integer id)
            {
                Optional<Cliente> clienteDelete = clientes.findById(id);
                if(clienteDelete.isPresent())
                    {
                        clientes.delete(clienteDelete.get());
                        return ResponseEntity.noContent().build();
                    }
                return ResponseEntity.notFound().build();
            }

        @PostMapping("/clientes")
        @ResponseBody
        public ResponseEntity save(@RequestBody Cliente cliente)
            {
                Cliente clienteSalvo = clientes.save(cliente);
                return ResponseEntity.ok(clienteSalvo);
            }

        @PutMapping(value = "/clientes/{cod}")
        @ResponseBody
        public ResponseEntity updateClienteById
                (
                    @PathVariable("cod") Integer id,
                    @RequestBody Cliente cliente
                )
            {
                if(clientes.findById(id).isPresent())
                    {
                        clientes.updateById( id, cliente.getNome());
                        return ResponseEntity.ok(clientes.findById(id).get().toString());
                    }
                return ResponseEntity.notFound().build();
            }

        @GetMapping("/clientes")
        @ResponseBody
        public ResponseEntity find(Cliente filtro){
            ExampleMatcher matcher = ExampleMatcher
                                        .matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

            Example example = Example.of(filtro, matcher);
            List<Cliente> lista = clientes.findAll(example);
            return ResponseEntity.ok(lista);
        }
    }