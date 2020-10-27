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

import br.com.fiap.phoenix.APIdaVida.Entity.Artigo;
import br.com.fiap.phoenix.APIdaVida.Service.ArtigoService;

@RestController
@RequestMapping("/artigo")
public class ArtigoController {

	@Autowired
	private ArtigoService service;
	

	@GetMapping
	public List<Artigo> getAllArtigos(){
		return service.getAllArtigo();
	}
	@PostMapping
	public String save(@Valid @RequestBody Artigo artigo, BindingResult result) {
		if(result.hasErrors()) {
			return "Houve um error";
		}
		service.save(artigo);
		return  "Artigo Cadastrado com sucesso";
	}
	@PutMapping("/{id}")
	public ResponseEntity<Artigo> updateRelato(@PathVariable long id,
			@Valid @RequestBody  Artigo artigoDetails){
		
		return service.updateArtigo(id, artigoDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRelato(@PathVariable long id){
		return service.delete(id);
	}
}
