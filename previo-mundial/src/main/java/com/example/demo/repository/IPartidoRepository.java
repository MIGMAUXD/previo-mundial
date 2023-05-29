package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Partido;

public interface IPartidoRepository extends JpaRepository<Partido, Integer>{

}
