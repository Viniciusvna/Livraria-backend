package com.eliwelton.livraria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.eliwelton.livraria.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Cliente findById(long id);
	
}
