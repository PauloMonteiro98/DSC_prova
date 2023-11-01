package com.prova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.demo.domain.autor.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
  
}

