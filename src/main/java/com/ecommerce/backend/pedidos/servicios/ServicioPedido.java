package com.ecommerce.backend.pedidos.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.backend.pedidos.entidades.Pedido;
import com.ecommerce.backend.pedidos.repositorios.RepositorioPedido;

@Service
public class ServicioPedido {
	
	@Autowired
	private RepositorioPedido repositorioPedido;
	
	public List<Pedido> obtenerPedidosPorUsuario(Long id){
        return this.repositorioPedido.findByUsuario(id);
    }

    public void crearPedido(Pedido pedido){
    	this.repositorioPedido.save(pedido);
    }

}
