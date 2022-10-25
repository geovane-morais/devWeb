package web.api.app.domain.repository;
import web.api.app.domain.entity.Cliente;
import web.api.app.domain.entity.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository <Pedido, Integer> {
    List<Pedido> findByCliente (Cliente cliente);
}
