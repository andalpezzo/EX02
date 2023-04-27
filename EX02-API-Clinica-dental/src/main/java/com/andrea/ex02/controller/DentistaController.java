
package com.andrea.ex02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrea.ex02.dto.Dentista;
import com.andrea.ex02.dto.Visita;
import com.andrea.ex02.service.DentistaService;
import com.andrea.ex02.service.VisitaService;

@RestController
@RequestMapping("/api")
public class DentistaController {

	@Autowired
	DentistaService dentistaService;

	@Autowired
	VisitaService visitaService;

	@GetMapping("/dentistas")
	public List<Dentista> listDentistas() {
		return dentistaService.listDentistas();
	}

	@GetMapping("/dentista/{dentistaDni}")
	public Dentista dentistaById(@PathVariable(name = "dentistaDni") String dni) {
		Dentista dentistaxID = new Dentista();

		dentistaxID = dentistaService.dentistaXDni(dni);

		return dentistaxID;
	}

	@GetMapping("/dentistas/{dentistaDni}/visitas")
	public List<Visita> listVisitasByDentistaId(@PathVariable(name = "dentistaDni") String dni) {
		return visitaService.listVisitasByDentistaId(dni);
	}

	@PostMapping("/dentistas")
	public Dentista saveDentista(@RequestBody Dentista dentista) {
		return dentistaService.saveDentista(dentista);
	}

	@PutMapping("/dentista/{dentistaDni}")
	public Dentista updateDentista(@PathVariable(name = "dentistaDni") String dni, @RequestBody Dentista dentista) {
		
		Dentista dentista_seleccionado = new Dentista();
		Dentista dentista_actualizado = new Dentista();
		
		dentista_seleccionado = dentistaService.dentistaXDni(dni);
		
		dentista_seleccionado.setNomapels(dentista.getNomapels());
		
		dentista_actualizado = dentistaService.updateDentista(dentista_seleccionado);
		
		System.out.println("El dentista actualizado es: "+ dentista_actualizado);
		
		return dentista_actualizado;
	}

	@DeleteMapping("/dentistas/{dentistaDni}")
	public void deleteDentista(@PathVariable(name = "dentistaDni") String dni) {
		dentistaService.deleteDentista(dni);
	}
}
