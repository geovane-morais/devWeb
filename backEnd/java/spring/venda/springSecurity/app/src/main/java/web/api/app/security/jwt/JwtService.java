package web.api.app.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;
import web.api.app.domain.entity.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("{security.jwt.expiracao}")
    private String expiracao;
    @Value("{security.jwt.chave-assinatura}")
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
                .setSubject(usuario.getLogin())
                .setExpiration(data)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.ES512, chaveAssinatura)
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
            return LocalDateTime.now().isBefore(data);
        }catch (Exception e){
            return false;
        }
    }

    public String getLoginUsuario (String token) throws ExpiredJwtException{
        return (String) getClaims(token).getSubject();
    }
}
