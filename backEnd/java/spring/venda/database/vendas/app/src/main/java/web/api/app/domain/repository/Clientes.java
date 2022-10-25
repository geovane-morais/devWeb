package web.api.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.api.app.domain.entity.Cliente;

import java.util.List;


public interface Clientes extends JpaRepository <Cliente, Integer> {

    @Query(value= "select c from Cliente c where c.nome like :nome")
    List<Cliente> findByNomeLike (@Param("nome") String nome);

    @Query(value=" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome (String nome);

    boolean existsByNome (String nome);

    @Query(value = " select c from Cliente c left join fetch c.pedidos p where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}