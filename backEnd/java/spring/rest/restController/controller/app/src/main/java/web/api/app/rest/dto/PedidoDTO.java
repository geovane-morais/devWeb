package web.api.app.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class PedidoDTO {
    private Integer clienteId;
    private BigDecimal total;
    private List<itemPedidoDTO> items;
}

