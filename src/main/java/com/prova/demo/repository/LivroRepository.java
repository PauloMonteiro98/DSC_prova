package com.prova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.demo.domain.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
  
}
