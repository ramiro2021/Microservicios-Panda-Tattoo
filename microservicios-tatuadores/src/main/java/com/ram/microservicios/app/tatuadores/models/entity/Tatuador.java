package com.ram.microservicios.app.tatuadores.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Tatuadores")

public class Tatuador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private int edad;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	//@JsonIgnoreProperties(value = {"tatuador"} , allowSetters = true)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "tatuador"})
	@OneToMany(mappedBy = "tatuador", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Trabajo> trabajos;
	
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
		
	public Tatuador() {
		this.trabajos = new ArrayList<>();
	}


	public List<Trabajo> getTrabajos() {
		return trabajos;
	}




	public void setTrabajos(List<Trabajo> trabajos) {
		this.trabajos.clear();
		trabajos.forEach(this::addTrabajos);
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
	public void addTrabajos(Trabajo trabajo) {
		this.trabajos.add(trabajo);
		trabajo.setTatuador(this);
	}
	
	public void removeTrabajos(Trabajo trabajo) {
		this.trabajos.remove(trabajo);
		trabajo.setTatuador(null);
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Tatuador)) {
			return false;
		}
		
		Tatuador tatuador = (Tatuador) obj;
		
		return this.id != null && this.id.equals(tatuador.getId());
	}
	
	
}
