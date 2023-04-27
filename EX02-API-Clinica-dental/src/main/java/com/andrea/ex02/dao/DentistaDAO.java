package com.andrea.ex02.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrea.ex02.dto.Dentista;

public interface DentistaDAO extends JpaRepository<Dentista, String> {

}
