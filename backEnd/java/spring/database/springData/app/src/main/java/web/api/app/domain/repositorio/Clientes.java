package web.api.app.domain.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.api.app.domain.entity.Cliente;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value= "select c from Cliente c where c.nome like :nome")
    List<Cliente> findByNomeLike (@Param("nome") String nome);

    @Query(value=" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome (String nome);

    boolean existsByNome (String nome);
}