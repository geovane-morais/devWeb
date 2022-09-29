package web.api.app.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME", length = 100)
    private String nome;
    @Column(name = "CPF", length = 11)
    private String cpf;

    /*Linkando os pedidos para os clientes*/
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Cliente(String nome) {
        this.nome = nome;
    }
}