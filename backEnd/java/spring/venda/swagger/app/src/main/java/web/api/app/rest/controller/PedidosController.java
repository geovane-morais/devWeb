package web.api.app.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.server.ResponseStatusException;
import web.api.app.domain.entity.enums.StatusPedido;
import web.api.app.rest.dto.pedidoDTO;
import web.api.app.rest.dto.responseItemInfPedDTO;
import web.api.app.rest.dto.informacoesPedidoDTO;
import web.api.app.service.PedidoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
@AllArgsConstructor
public class PedidosController {
    private PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody @Valid pedidoDTO dto) {
        return "Pedido ID:" + service.salvar(dto).getId();
    }

    @GetMapping("/{cod}")
    @ResponseStatus(HttpStatus.OK)
    public informacoesPedidoDTO getById(@PathVariable("cod") Integer id) {
        responseItemInfPedDTO response = new responseItemInfPedDTO();
        return service
                .obterPedidoCompletoPorId(id)
                .map(p -> response.pedidoToInfPedDTO(p))
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Não tem pedido com id " + id)
                );
    }

    @PatchMapping("/{cod}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(@PathVariable("cod") Integer id,
                             @RequestBody @Valid informacoesPedidoDTO dto
    ){
        service.updateStatusPedido(id, StatusPedido.valueOf(dto.getStatus()));
    }
}
