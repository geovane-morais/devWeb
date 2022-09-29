package web.api.app.service;

import web.api.app.domain.entity.Pedido;
import web.api.app.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService{
    Pedido salvar (PedidoDTO dto);
    Optional<Pedido> obterPedidoCompletoPorId (Integer id);
    Pedido delete (Integer id);
}
