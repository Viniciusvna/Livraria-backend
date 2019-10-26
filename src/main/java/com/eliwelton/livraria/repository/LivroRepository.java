package com.eliwelton.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eliwelton.livraria.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

	Livro findById(long id);
	
}
