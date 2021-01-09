package com.ram.microservicios.commons.insumos.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreCategoria;

	@JsonIgnoreProperties(value = { "categoria" })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "marca_categoria", 
			joinColumns = @JoinColumn(name = "fk_categoria"), 
			inverseJoinColumns = @JoinColumn(name = "fk_marca"))
	private List<Marca> marca;
	
	public Categoria() {
		this.marca = new ArrayList<>();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public List<Marca> getMarca() {
		return marca;
	}

	public void setMarca(List<Marca> marca) {
		this.marca = marca;
	}
	
	
	
	
	
}
