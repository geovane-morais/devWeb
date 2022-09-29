package web.api.app.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /*ForeKey*/
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;
    @Column(name = "total", precision=20, scale = 2)
    private BigDecimal total;

    /*Linkando os pedidos para os clientes*/
    @OneToMany(mappedBy = "pedido")
    private List<itemPedido> itemPedidos;
    public List<itemPedido> getItemPedidos() {return itemPedidos;}
    public void setItemPedidos(List<itemPedido> itemPedidos) {this.itemPedidos = itemPedidos;}
    /*====================================*/

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    public LocalDate getDataPedido() {return dataPedido;}
    public void setDataPedido(LocalDate dataPedido) {this.dataPedido = dataPedido;}
    public BigDecimal getTotal() {return total;}
    public void setTotal(BigDecimal total) {this.total = total;}

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", total=" + total +
                '}';
    }
}
