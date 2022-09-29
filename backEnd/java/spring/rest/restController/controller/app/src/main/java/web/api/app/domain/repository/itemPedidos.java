package web.api.app.domain.repository;

import web.api.app.domain.entity.itemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface itemPedidos extends JpaRepository<itemPedido, Integer> {
}
