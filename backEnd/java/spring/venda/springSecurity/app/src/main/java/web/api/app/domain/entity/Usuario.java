package web.api.app.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotEmpty(message = "Campo login é obrigatorio")
    @Column(name = "LOGIN")
    private String login;

    @NotEmpty(message = "Campo pass é obrigatorio")
    @Column(name = "PASSWORD")
    private String pass;

    @NotNull(message = "Campo admin é obrigatorio")
    @Column(name = "ADMIN")
    private boolean admin;
}
