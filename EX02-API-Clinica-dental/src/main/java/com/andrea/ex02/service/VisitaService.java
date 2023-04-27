
package com.andrea.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.ex02.dao.VisitaDAO;
import com.andrea.ex02.dto.Visita;

@Service
public class VisitaService {

	@Autowired
	VisitaDAO visitaDAO;

	public List<Visita> listVisitas() {
		return visitaDAO.findAll();
	}

	public List<Visita> listVisitasByClientId(String dniCliente) {
		return visitaDAO.findVisitaByClienteDni(dniCliente);
	}

	public List<Visita> listVisitasByDentistaId(String dniDentista) {
		return visitaDAO.findVisitaByDentistaDni(dniDentista);
	}

	public Visita saveVisita(Visita visita) {
		return visitaDAO.save(visita);
	}

	public Visita visitaXId(Long id) {
		return visitaDAO.findById(id).get();
	}

	public Visita updateVisita(Visita visita) {
		return visitaDAO.save(visita);
	}

	public void deleteVisita(Long id) {
		visitaDAO.deleteById(id);
	}
}
