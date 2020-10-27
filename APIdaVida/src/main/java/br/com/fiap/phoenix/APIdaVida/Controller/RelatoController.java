package br.com.fiap.phoenix.APIdaVida.Controller;

import java.beans.Transient;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.phoenix.APIdaVida.Entity.Relato;
import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Service.RelatoService;

@RestController
@RequestMapping("/relato")
public class RelatoController {
	
	@Autowired
	private RelatoService service;
	

	@GetMapping
	public List<Relato> getAllRelatos(){
		return service.AllRelatos();
	}
	
	@PostMapping
	public String save(@Valid @RequestBody Relato relato, BindingResult result) {
		if(result.hasErrors()) {
			return "Houve um error";
		}
		service.save(relato);
		return  "Relato Cadastrado com sucesso";
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Relato> updateRelato(@PathVariable long id,
			@Valid @RequestBody  Relato relatoDetails){
		
		return service.updateRelato(id, relatoDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRelato(@PathVariable long id){
		return service.delete(id);
	}
	

}
