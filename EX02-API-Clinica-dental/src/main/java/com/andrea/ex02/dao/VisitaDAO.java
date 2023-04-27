package com.andrea.ex02.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrea.ex02.dto.Visita;

public interface VisitaDAO extends JpaRepository<Visita, Long> {
	
	public List<Visita> findVisitaByDentistaDni(String dniDentista);
	
	public List<Visita> findVisitaByClienteDni(String dniCliente);
}
