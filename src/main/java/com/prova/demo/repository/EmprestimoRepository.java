package com.prova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.demo.domain.emprestimo.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
  
}
