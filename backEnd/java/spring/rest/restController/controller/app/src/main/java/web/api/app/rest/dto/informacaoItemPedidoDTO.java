package web.api.app.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.api.app.domain.entity.Pedido;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class informacaoItemPedidoDTO {
    private Integer id;
    private String descricaoProduto;
    private BigDecimal precoUnitario;
    private Integer quantidade;
}
