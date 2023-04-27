package com.andrea.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrea.ex02.dao.ClienteDAO;
import com.andrea.ex02.dto.Cliente;

@Service
public class ClienteService {

	@Autowired
	ClienteDAO clienteDAO;

	public List<Cliente> listClientes() {
		return clienteDAO.findAll();
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	public Cliente clienteXDni(String dni) {
		return clienteDAO.findById(dni).get();
	}

	public Cliente updateCliente(Cliente cliente) {
		return clienteDAO.save(cliente);
	}

	public void deleteCliente(String dni) {
		clienteDAO.deleteById(dni);
	}
}
