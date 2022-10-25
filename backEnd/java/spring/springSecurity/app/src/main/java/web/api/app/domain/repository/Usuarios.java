package web.api.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.api.app.domain.entity.Usuario;

import java.util.Optional;

public interface Usuarios extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.login = :login")
    Optional<Usuario> findByLogin(@Param("login") String login);
}
