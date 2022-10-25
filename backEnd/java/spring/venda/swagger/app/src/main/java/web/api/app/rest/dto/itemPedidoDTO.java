package web.api.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.api.app.domain.entity.Pedido;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class itemPedidoDTO {
    private Integer produtoId;
    private Integer quantidade;
    //private Pedido pedido;
}
