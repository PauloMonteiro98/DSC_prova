package com.prova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova.demo.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  
}
