package com.SalesKomet.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_flores")
public class FloresEntity implements Serializable {
	
	@Id 
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	
	@jakarta.persistence.Column(updatable = false)
	private LocalDateTime fechaCreacion;
	@jakarta.persistence.Column(insertable = false)
	private LocalDateTime fechaActualizacion;
	
	@jakarta.persistence.PrePersist
	public void prePersist() { 				
		fechaCreacion = LocalDateTime.now();
	}	
	
	@jakarta.persistence.PreUpdate
	public void preUpdte() {
		fechaActualizacion = LocalDateTime.now();
	}	
			
	public void updateName () {
		System.out.print(name);
		this.name += " -kometsales";
		System.out.print(name);
	} 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}	
		
	
}
