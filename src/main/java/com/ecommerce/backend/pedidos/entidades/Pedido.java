package com.ecommerce.backend.pedidos.entidades;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id_pedido;
	
	private Date fechaPedido = new Date();
	
	@Positive(message = "El valor total del pedido debe ser positivo.")
	private double totalDinero;
	
	private List<Long> productos;
	
	private Long usuario;
}
