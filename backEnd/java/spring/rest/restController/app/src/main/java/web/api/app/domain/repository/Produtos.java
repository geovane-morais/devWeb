package web.api.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.api.app.domain.entity.Produto;

public interface Produtos extends JpaRepository <Produto, Integer> {
}
