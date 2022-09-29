package web.api.app.domain.entity;

import lombok.*;

import javax.persistence.*;
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
    private Cliente cliente;

    @Column(name = "DATA_PEDIDO")
    private LocalDate dataPedido;
    @Column(name = "TOTAL", precision = 20, scale = 2)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private List<itemPedido> itemPedidos;
}
