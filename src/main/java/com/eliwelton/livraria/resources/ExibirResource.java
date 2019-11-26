package com.eliwelton.livraria.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliwelton.livraria.models.Exibir;
import com.eliwelton.livraria.repository.ExibirRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Livros")
@CrossOrigin(origins="*")
public class ExibirResource {

	@Autowired
	ExibirRepository exibirRepository;
	
	@CrossOrigin
	@GetMapping("/exibir")
	@ApiOperation(value="Exibir data formatada")
	public Iterable<Exibir> listaExibir(){
		return exibirRepository.findAll();
	}
}