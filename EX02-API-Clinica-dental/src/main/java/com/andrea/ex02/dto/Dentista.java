package com.andrea.ex02.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dentistas")
public class Dentista {

	//Atributos de la entidad dentista
	@Id
	private String dni;
	private String nomapels;
	private int telefono;
	private String email;
	private String especialidad;

	@OneToMany
	@JoinColumn(name = "dentista")
	private List<Visita> visita;

	//Constructores
	public Dentista() {
		
	}

	public Dentista(String dni, String nomapels, int telefono, String email, String especialidad) {
		this.dni = dni;
		this.nomapels = nomapels;
		this.telefono = telefono;
		this.email = email;
		this.especialidad = especialidad;
	}

	//Getters and setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Visita")
	public List<Visita> getVisita() {
		return visita;
	}

	public void setVisita(List<Visita> visita) {
		this.visita = visita;
	}

}
