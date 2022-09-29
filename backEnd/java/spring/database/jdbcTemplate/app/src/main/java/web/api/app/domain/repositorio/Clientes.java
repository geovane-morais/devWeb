package web.api.app.domain.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import web.api.app.domain.entity.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {
    @Autowired
     private JdbcTemplate jdbcTemplate;
     private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES (?)";
     private static String SELECT_ALL = "SELECT * FROM CLIENTE";
     private static String SELECT_PER_NAME = "SELECT * FROM CLIENTE WHERE NOME LIKE ?";
     private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";
     private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";

     public Cliente salvar(Cliente cliente){
         jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
         return cliente;
     }

     public void deletar(Integer ID){
        jdbcTemplate.update(DELETE, new Object[]{ID});
     }
     public void deletar(Cliente cliente){
        deletar(cliente.getId());
     }

     public  Cliente atualizar (Cliente cliente){
         jdbcTemplate.update(UPDATE, new Object[]{
             cliente.getNome(),cliente.getId()
         });
         return cliente;
     }

     public List<Cliente> buscarPorNome(String NOME){
         return jdbcTemplate.query(SELECT_PER_NAME, new Object[]{"%" +NOME+ "%"}, RowMapperClientes());
     }

     public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, RowMapperClientes());
     }

     private RowMapper<Cliente> RowMapperClientes() {
         return (new RowMapper<Cliente>() {
             @Override
             public Cliente mapRow (ResultSet rs,int i) throws SQLException {
                 return  new Cliente(rs.getInt("ID"),rs.getString("nome"));
             }
         });
     }
}