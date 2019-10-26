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

import com.eliwelton.livraria.models.Cliente;
import com.eliwelton.livraria.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Clientes")
@CrossOrigin(origins="*")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	@ApiOperation(value="Retorna uma lista de clientes")
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	@ApiOperation(value="Retorna um cliente unico")
	public Cliente listaClienteUnico(@PathVariable(value="id") long id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping("/cliente")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Salva um cliente")
	public String salvaCliente(@RequestBody @Valid Cliente cliente, BindingResult result){
		if(result.hasErrors()){
			return "Verifique os campos!";
		}
		clienteRepository.save(cliente);
		return "Cliente salvo com sucesso!";
	}
	
	@DeleteMapping("/cliente")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Deleta um cliente")
	public String deletaCliente(@RequestBody @Valid Cliente cliente, BindingResult result){
		if(result.hasErrors()){
			return "Dado nao existe!";
		}
		clienteRepository.delete(cliente);
		return "Cliente DELETADO!!!";
	}
	
	@PutMapping("/cliente")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value="Atualiza um cliente")
	public String atualizaCliente(@RequestBody @Valid Cliente cliente, BindingResult result){
		if(result.hasErrors()){
			return "Verifique os campos!";
		}
		clienteRepository.save(cliente);
		return "Dados alterados com sucesso!";
	}
	
}
