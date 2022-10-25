package web.api.app.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CredenciasDTO {
    @NotEmpty(message = "Campo login é obrigatorio")
    private String login;
    @NotEmpty(message = "Campo password é obrigatorio")
    private String password;
}
