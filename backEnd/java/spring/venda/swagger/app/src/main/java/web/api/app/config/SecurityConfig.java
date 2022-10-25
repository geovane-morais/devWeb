package web.api.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import web.api.app.security.jwt.JwtAuthFilter;
import web.api.app.security.jwt.JwtService;
import web.api.app.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtService jwtService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean/*Implementação da autenticação por JWT*/
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService,userService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                    .antMatchers("/api/usuarios/auth").permitAll()
                    .antMatchers("/swagger-ui.html").permitAll()
                .and()
                    .httpBasic();
        http
                .csrf().disable().authorizeRequests()
                    .antMatchers("/api/clientes/**").hasRole("ADMIN")
                    .antMatchers("/api/produtos/**").hasRole("ADMIN")
                    .antMatchers("/api/pedidos/**").hasAnyRole("ADMIN","USER")
                    .antMatchers(HttpMethod.POST,"/api/usuarios").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring().antMatchers("/database/**")
                .and()
                .ignoring()
                .antMatchers(
                        "/v2/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security,",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-ui.html#/**",
                        "/swagger-ui.html#"
                );
    }
}
