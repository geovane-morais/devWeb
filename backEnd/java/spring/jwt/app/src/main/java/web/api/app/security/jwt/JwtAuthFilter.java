package web.api.app.security.jwt;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import web.api.app.service.impl.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserServiceImpl userService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
        ) throws ServletException, IOException
    {
        String authorization = request.getHeader("Authorization");

        if(authorization != null || authorization.startsWith("Bearer")){
            String token = authorization.split(" ")[1];
            boolean isValid = jwtService.tokenValido(token);

            if(isValid){
                String loginUsuario = jwtService.getLoginUsuario(token);
                UserDetails usuario = userService.loadUserByUsername(loginUsuario);

                UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());

                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(user);
            }
        }
        filterChain.doFilter(request,response);
    }
}
