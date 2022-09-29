package web.api.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import web.api.app.domain.entity.Cliente;
import web.api.app.domain.entity.Pedido;
import web.api.app.domain.repository.Clientes;
import web.api.app.domain.repository.Pedidos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AppApplication
{
	@Bean
	public CommandLineRunner init
			(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos
			)
		{
			return args ->
				{
					System.out.println("\n***Inserir no BANCO***");
					Cliente cliente1 = new Cliente("Geovane");
					Cliente cliente2 = new Cliente("Douglas");
					clientes.save(cliente1);
					clientes.save(cliente2);
					List<Cliente> todosCLientes = clientes.findAll();
					todosCLientes.forEach(System.out::println);

					Pedido p = new Pedido();
					p.setCliente(cliente1);
					p.setDataPedido(LocalDate.now());
					p.setTotal(BigDecimal.valueOf(100));
					pedidos.save(p);

					System.out.println("\n***Clientes com pedidos***");
					Cliente cliente = clientes.findClienteFetchPedidos(cliente1.getId());
					System.out.println(cliente);
					System.out.println(cliente.getPedidos());
					pedidos.findByCliente(cliente1).forEach(System.out::println);
				};
		}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}