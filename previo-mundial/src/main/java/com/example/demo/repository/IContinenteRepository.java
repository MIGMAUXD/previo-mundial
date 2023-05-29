package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Continente;

public interface IContinenteRepository extends JpaRepository<Continente, Integer> {

}
