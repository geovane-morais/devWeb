package web.api.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import web.api.app.domain.entity.Usuario;
import web.api.app.security.jwt.JwtService;

@SpringBootApplication
public class AppApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(AppApplication.class, args);
    }
}