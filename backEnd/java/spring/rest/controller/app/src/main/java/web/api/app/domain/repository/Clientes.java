package web.api.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import web.api.app.domain.entity.Cliente;

import java.util.List;


public interface Clientes extends JpaRepository <Cliente, Integer> {

    @Query(value= "select c from Cliente c where c.nome like :nome")
    List<Cliente> findByNomeLike (@Param("nome") String nome);

    @Query(value= "select c from Cliente c where c.id = :id")
    List<Cliente> findById (@Param("id") String id);

    @Query(value=" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome (String nome);

    @Query(value=" delete from Cliente c where c.id =:id ")
    @Modifying
    void deleteById (Integer id);

    @Transactional
    @Modifying
    @Query(value=" update Cliente c set nome=:nome where c.id =:id ")
    void updateById (Integer id, String nome);

    boolean existsByNome (String nome);

    @Query(value = " select c from Cliente c left join fetch c.pedidos p where c.id =:id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}