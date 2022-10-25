package web.api.app.domain.entity;

import lombok.*;
import web.api.app.domain.entity.enums.StatusPedido;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter@Setter
@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /*ForeKey*/
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    @NotNull(message = "{campo.cliente-pedido.obrigatorio}")
    private Cliente cliente;

    @Column(name = "DATA_PEDIDO")
    private LocalDate dataPedido;

    @Column(name = "TOTAL", precision = 20, scale = 2)
    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    @NotEmpty(message = "{campo.items-pedido.obrigatorio}")
    private List<itemPedido> itemPedidos;

    @Enumerated(EnumType.STRING)
    @Column(name = "`STATUS`")
    private StatusPedido statusPedido;
}
