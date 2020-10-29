package br.com.fiap.phoenix.APIdaVida.Controller;

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

import br.com.fiap.phoenix.APIdaVida.Entity.CursoCapacitacao;
import br.com.fiap.phoenix.APIdaVida.Service.CursoCapacitacaoService;

@RestController
@RequestMapping("/curso")
public class CursoCapacitacaoController {
	
	@Autowired
	private CursoCapacitacaoService service;
	
	
	@GetMapping
	public List<CursoCapacitacao> getAllCursos(){
		return service.AllCursos();
	}
	
	@PostMapping
	public String save(@Valid @RequestBody CursoCapacitacao c, BindingResult result) {
		if(result.hasErrors()) {
			return "Houve um error";
		}
		service.save(c);
		return  "Curso de Capacitação  Cadastrado com sucesso";
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CursoCapacitacao> updateRelato(@PathVariable long id,
			@Valid @RequestBody  CursoCapacitacao c){
		
		return service.update(id, c);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return service.delete(id);
	}

}
