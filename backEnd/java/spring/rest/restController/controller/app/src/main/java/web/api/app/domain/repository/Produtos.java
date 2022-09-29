package web.api.app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import web.api.app.domain.entity.Produto;

import java.math.BigDecimal;

public interface Produtos extends JpaRepository<Produto, Integer> {

    @Transactional
    @Modifying
    @Query(value = " update Produto p set p.descricao=:descricao, p.preco=:preco where p.id =:id ")
    void updateById(Integer id, String descricao, BigDecimal preco);
}
