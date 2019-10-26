package com.eliwelton.livraria.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eliwelton.livraria.models.Livro;
import com.eliwelton.livraria.repository.LivroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Livros")
@CrossOrigin(origins="*")
public class LivroResource {

	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping("/livros")
	@ApiOperation(value="Retorna uma lista de livros")
	public List<Livro> listaLivros(){
		return livroRepository.findAll();
	}
	
	@GetMapping("/livro/{id}")
	@ApiOperation(value="Retorna um livro unico")
	public Livro listaLivroUnico(@PathVariable(value="id") long id){
		return livroRepository.findById(id);
	}
	
	@PostMapping("/livro")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Salva um livro")
	public String salvaLivro(@RequestBody @Valid Livro livro, BindingResult result){
		if(result.hasErrors()){
			return "Verifique os campos!";
		}
		livroRepository.save(livro);
		return "Livro salvo com sucesso!";
	}
	
	@DeleteMapping("/livro")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Deleta um livro")
	public String deletaLivro(@RequestBody @Valid Livro livro, BindingResult result){
		if(result.hasErrors()){
			return "Dado nao existe!";
		}
		livroRepository.delete(livro);
		return "Livro DELETADO!!!";
	}
	
	@PutMapping("/livro")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Atualiza um livro")
	public String atualizaLivro(@RequestBody @Valid Livro livro, BindingResult result){
		if(result.hasErrors()){
			return "Verifique os campos!";
		}
		livroRepository.save(livro);
		return "Dados alterados com sucesso!";
	}
	
}
