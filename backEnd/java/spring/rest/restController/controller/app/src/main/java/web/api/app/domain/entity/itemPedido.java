package web.api.app.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter@Setter
@Entity
@Table(name = "item_pedido")
public class itemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "PRODUTO_ID")
    private Produto produto;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;
}
