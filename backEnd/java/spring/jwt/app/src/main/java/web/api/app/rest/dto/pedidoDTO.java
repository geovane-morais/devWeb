package web.api.app.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import web.api.app.validation.NotEmptyList;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class pedidoDTO {
    @NotNull(message = "{campo.cliente-pedidoDTO.obrigatorio}")
    private Integer clienteId;
    @NotNull(message = "{campo.total-pedidoDTO.obrigaorio}")
    private BigDecimal total;
    @NotEmptyList(message = "{campo.items.pedidoDTO.obrigatorio}")
    private List<itemPedidoDTO> items;
}

