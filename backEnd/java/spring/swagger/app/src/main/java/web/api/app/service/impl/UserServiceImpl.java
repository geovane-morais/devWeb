package web.api.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.api.app.config.SecurityConfig;
import web.api.app.domain.entity.Usuario;
import web.api.app.domain.repository.Usuarios;
import web.api.app.exception.SenhaInvalidaException;

@Service
public class UserServiceImpl implements UserDetailsService{

    private final PasswordEncoder passwordEncoder = new SecurityConfig().passwordEncoder();

    @Autowired
    private Usuarios usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario u){
        String passEncrypted = passwordEncoder.encode(u.getPass());
        u.setPass(passEncrypted);
        return usuarioRepository.save(u);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository
                .findByLogin(username)
                .orElseThrow(()-> new UsernameNotFoundException("Não tem usuarios na base de dados"));

        String[] roles = u.isAdmin() ? new String[]{"ADMIN", "USER"} : new String[]{"USER"};
        return User.builder()
                    .username(u.getLogin())
                    .password(u.getPass())
                    .roles(roles)
                    .build();
    }

    public UserDetails autenticar(Usuario usuario){
        UserDetails u = loadUserByUsername(usuario.getLogin());
        boolean isPassTrue = passwordEncoder.matches(usuario.getPass(), u.getPassword());
        if(isPassTrue) { return u; }
        throw new SenhaInvalidaException();
    }
}
