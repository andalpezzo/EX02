package com.andrea.ex02.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrea.ex02.dto.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, String> {

}
