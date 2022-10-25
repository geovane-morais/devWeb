package web.api.app.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import web.api.app.AppApplication;
import web.api.app.domain.entity.Usuario;
import web.api.app.domain.repository.Usuarios;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;
    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken (Usuario usuario){
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao =  LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        /*Opcional*/
        HashMap<String,Object> claims = new HashMap<>();
        claims.put("id",usuario.getId());
        claims.put("admin", usuario.isAdmin());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(usuario.getLogin())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS256, chaveAssinatura)
                .compact();
    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(chaveAssinatura)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValido (String token){
        try {
            Claims claims = getClaims(token);
            Date dataExpiracao = claims.getExpiration();
            /*Converter date para LocalDateTime*/
            LocalDateTime data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            boolean isValid = LocalDateTime.now().isBefore(data);
            return isValid;
        }catch (Exception e){
            System.out.println("\n\nError:"+e.toString()+"\n\n");
            return false;
        }
    }

    public String getLoginUsuario (String token) throws ExpiredJwtException{
        return (String) getClaims(token).getSubject();
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppApplication.class,args);
        JwtService jwtService = context.getBean(JwtService.class);
        Usuarios usuarios = context.getBean(Usuarios.class);
        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        Usuario usuario = Usuario.builder()
                .login("admin")
                .pass(encoder.encode("admin"))
                .admin(true)
                .build();
        usuarios.save(usuario);

        String token = jwtService.gerarToken(usuario);
        System.out.println("\n\nTOKEN: "+ token +"\n\n");
    }
}
