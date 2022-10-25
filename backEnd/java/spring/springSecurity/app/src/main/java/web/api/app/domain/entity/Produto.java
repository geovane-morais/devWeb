package web.api.app.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter@Setter
@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRICAO")
    @NotEmpty(message = "{campo.desccricao-produto.obrigatorio}")
    private String descricao;

    @Column(name = "PRECO_UNITARIO")
    @NotNull(message = "{campo.preco-produto.obrigatorio}")
    private BigDecimal preco;
}
