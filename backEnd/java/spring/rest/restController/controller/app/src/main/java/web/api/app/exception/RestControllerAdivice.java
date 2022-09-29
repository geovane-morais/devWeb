package web.api.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class RestControllerAdivice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraNegocioExeption(RegraNegocioException ex){
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }
}

class ApiErros {
    @Getter
    private final List<String> erros;

    public ApiErros(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }
}
