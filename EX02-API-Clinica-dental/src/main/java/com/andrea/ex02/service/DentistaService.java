
package com.andrea.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.ex02.dao.DentistaDAO;
import com.andrea.ex02.dto.Dentista;

@Service
public class DentistaService {

	@Autowired
	DentistaDAO dentistaDAO;

	public List<Dentista> listDentistas() {
		return dentistaDAO.findAll();
	}

	public Dentista saveDentista(Dentista dentista) {
		return dentistaDAO.save(dentista);
	}

	public Dentista dentistaXDni(String dni) {
		return dentistaDAO.findById(dni).get();
	}

	public Dentista updateDentista(Dentista dentista) {
		return dentistaDAO.save(dentista);
	}

	public void deleteDentista(String dni) {
		dentistaDAO.deleteById(dni);
	}
}
