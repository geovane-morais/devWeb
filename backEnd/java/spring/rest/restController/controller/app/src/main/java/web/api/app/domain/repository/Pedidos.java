package web.api.app.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.api.app.domain.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

    @Query(value = "SELECT p FROM Pedido p left join fetch p.itemPedidos WHERE p.id = :id")
    Optional<Pedido> findByIdFetchItems(@Param("id")Integer id);
}
