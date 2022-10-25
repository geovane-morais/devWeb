package web.api.app.domain.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @Column(name = "NOME")
    @NotNull(message = "{campo.nome-cliente.obrigatorio}")
    private String nome;

    @Column(name = "CPF", length = 11)
    @NotEmpty(message = "{campo.cpf-cliente.obrigatorio}")
    @CPF(message = "{campo.cpf-cliente.valido}")
    private String cpf;

    /*Linkando os pedidos para os clientes*/
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Cliente(String nome) {
        this.nome = nome;
    }
}