package com.ecommerce.backend.pedidos.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.ecommerce.backend.pedidos.entidades.Pedido;

public interface RepositorioPedido extends CrudRepository<Pedido, Long> {

	Pedido save(Pedido pedido);
	List<Pedido> findByUsuario(Long usuario);
}
