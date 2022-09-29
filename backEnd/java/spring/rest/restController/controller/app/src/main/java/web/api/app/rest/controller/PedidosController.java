package web.api.app.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.server.ResponseStatusException;
import web.api.app.domain.entity.Pedido;
import web.api.app.domain.entity.itemPedido;
import web.api.app.rest.dto.PedidoDTO;
import web.api.app.rest.dto.informacaoItemPedidoDTO;
import web.api.app.rest.dto.informacoesPedidoDTO;
import web.api.app.rest.dto.responseDTO;
import web.api.app.service.PedidoService;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
@AllArgsConstructor
public class PedidosController {
    private PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody PedidoDTO dto) {
        return "Pedido ID:" + service.salvar(dto).getId();
    }

    @GetMapping("/{cod}")
    @ResponseStatus(HttpStatus.OK)
    public informacoesPedidoDTO getById(@PathVariable("cod") Integer id) {
        responseDTO response = new responseDTO();
        return service
                .obterPedidoCompletoPorId(id)
                .map(p -> pedidoToInfPedDTO(p))
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Não tem pedido com id " + id)
                );
    }

    public informacoesPedidoDTO pedidoToInfPedDTO(Pedido p) {
        return informacoesPedidoDTO
                .builder()
                .id(p.getId())
                .dataPedido(p.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .CPF(p.getCliente().getCpf())
                .nomeCliente(p.getCliente().getNome())
                .total(p.getTotal())
                .items(itemToInfItemDTO(p.getItemPedidos()))
                .build();
    }

    private List<informacaoItemPedidoDTO> itemToInfItemDTO(List<itemPedido> ip) {
        if (CollectionUtils.isEmpty(ip)){
            return Collections.emptyList();
        }
        return ip.stream().map(
                item -> informacaoItemPedidoDTO
                        .builder()
                        .descricaoProduto(item.getProduto().getDescricao())
                        .id(item.getId())
                        .precoUnitario(item.getProduto().getPreco())
                        .quantidade(item.getQuantidade())
                        .build()
        ).collect(Collectors.toList());
    }
}
