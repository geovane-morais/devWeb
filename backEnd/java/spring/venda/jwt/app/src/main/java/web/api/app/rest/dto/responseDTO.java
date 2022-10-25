package web.api.app.rest.dto;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import web.api.app.domain.entity.Pedido;
import web.api.app.domain.entity.itemPedido;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class responseDTO {
    public informacoesPedidoDTO pedidoToInfPedDTO(Pedido p) {
        return informacoesPedidoDTO
                .builder()
                .id(p.getId())
                .dataPedido(p.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .CPF(p.getCliente().getCpf())
                .nomeCliente(p.getCliente().getNome())
                .status(p.getStatusPedido().name())
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
