package web.api.app.service;

import web.api.app.domain.entity.Pedido;
import web.api.app.domain.entity.enums.StatusPedido;
import web.api.app.rest.dto.pedidoDTO;

import java.util.Optional;

public interface PedidoService{
    Pedido salvar (pedidoDTO dto);
    Optional<Pedido> obterPedidoCompletoPorId (Integer id);
    void updateStatusPedido (Integer id, StatusPedido status);
}
