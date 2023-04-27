/**
 * 
 */
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

import com.andrea.ex02.dto.Cliente;
import com.andrea.ex02.dto.Visita;
import com.andrea.ex02.service.ClienteService;
import com.andrea.ex02.service.VisitaService;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	VisitaService visitaService;
	
	@GetMapping("/clientes")
	public List<Cliente> listClientes() {
		return clienteService.listClientes();
	}

	@GetMapping("/clientes/{clienteDni}")
	public Cliente clienteById(@PathVariable(name = "clienteDni") String dni) {
		Cliente clientexID = new Cliente();

		clientexID = clienteService.clienteXDni(dni);

		return clientexID;
	}
	
	@GetMapping("/clientes/{clienteDni}/visitas")
	public List<Visita> listVisitasByClientId(@PathVariable(name = "clienteDni") String clientDni) {
		return visitaService.listVisitasByClientId(clientDni);
	}
	
	@PostMapping("/clientes")
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}

	@PutMapping("/clientes/{clienteDni}")
	public Cliente updateClient(@PathVariable(name = "clienteDni") String dni, @RequestBody Cliente cliente) {
		
		Cliente cliente_seleccionado = new Cliente();
		Cliente cliente_actualizado = new Cliente();
		
		cliente_seleccionado = clienteService.clienteXDni(dni);
		
		cliente_seleccionado.setNomapels(cliente.getNomapels());
		
		cliente_actualizado = clienteService.updateCliente(cliente_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ cliente_actualizado);
		
		return cliente_actualizado;
	}

	@DeleteMapping("/clientes/{clienteDni}")
	public void deleteClient(@PathVariable(name = "clienteDni") String dni) {
		clienteService.deleteCliente(dni);
	}
}
