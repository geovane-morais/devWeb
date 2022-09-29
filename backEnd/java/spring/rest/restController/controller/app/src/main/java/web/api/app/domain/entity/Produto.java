package web.api.app.domain.entity;

import lombok.*;

import javax.persistence.*;
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
    private String descricao;
    @Column(name = "PRECO_UNITARIO")
    private BigDecimal preco;
}
