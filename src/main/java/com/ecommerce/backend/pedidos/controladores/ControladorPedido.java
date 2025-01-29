package com.ecommerce.backend.pedidos.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.backend.pedidos.entidades.Pedido;
import com.ecommerce.backend.pedidos.servicios.ServicioPedido;

@RestController
@RequestMapping(path = "/pedidos", produces = "application/json")
public class ControladorPedido {
	
	@Autowired
	private ServicioPedido servicioPedido;
	
	@GetMapping("/usuario")
    public ResponseEntity<Object> obtenerPedidosPorUsuario(@RequestHeader("X-User-ID") Long idUsuario) {
        try {
            List<Pedido> pedidos = this.servicioPedido.obtenerPedidosPorUsuario(idUsuario);
            return ResponseEntity.ok(pedidos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los pedidos.");
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido, @RequestHeader("X-User-ID") Long idUsuario) {
        try {
        	pedido.setUsuario(idUsuario);
            this.servicioPedido.crearPedido(pedido);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear el pedido.");
        }
    }

}
