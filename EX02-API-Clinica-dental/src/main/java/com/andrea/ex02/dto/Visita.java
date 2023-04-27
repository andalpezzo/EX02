package com.andrea.ex02.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "visitas")
public class Visita {
	
	//Atributos de la entidad visita
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "dni_cliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "dni_dentista")
	private Dentista dentista;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fecha_hora")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaHora;

	@Column(name = "precio")
	private double precio;

	//Constructores
	public Visita() {
		
	}

	public Visita(long id, Cliente cliente, Dentista dentista, String descripcion, LocalDateTime fechaHora,
			double precio) {
		this.id = id;
		this.cliente = cliente;
		this.dentista = dentista;
		this.descripcion = descripcion;
		this.fechaHora = fechaHora;
		this.precio = precio;
	}

	//Getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Dentista getDentista() {
		return dentista;
	}

	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
