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

import com.andrea.ex02.dto.Visita;
import com.andrea.ex02.service.VisitaService;

@RestController
@RequestMapping("/api")
public class VisitaController {

	@Autowired
	VisitaService visitaService;
	
	@GetMapping("/visitas")
	public List<Visita> listVisitas() {
		return visitaService.listVisitas();
	}

	@GetMapping("/visitas/{id}")
	public Visita visitaById(@PathVariable(name = "id") Long id) {
		Visita visitaxID = new Visita();

		visitaxID = visitaService.visitaXId(id);

		return visitaxID;
	}
	
	@PostMapping("/visitas")
	public Visita saveVisita(@RequestBody Visita visita) {
		return visitaService.saveVisita(visita);
	}

	@PutMapping("/visitas/{id}")
	public Visita updateVisita(@PathVariable(name = "id") Long id, @RequestBody Visita visita) {
		
		Visita visita_seleccionada = new Visita();
		Visita visita_actualizada = new Visita();
		
		visita_seleccionada = visitaService.visitaXId(id);
		
		visita_seleccionada.setId(visita.getId());
		
		visita_actualizada = visitaService.updateVisita(visita_seleccionada);
		
		System.out.println("La visita actualizada es: "+ visita_actualizada);
		
		return visita_actualizada;
	}

	@DeleteMapping("/visitas/{id}")
	public void deleteVisita(@PathVariable(name = "id") Long id) {
		visitaService.deleteVisita(id);
	}
}
