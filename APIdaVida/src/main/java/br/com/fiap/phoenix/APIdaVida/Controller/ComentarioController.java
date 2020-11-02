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

import br.com.fiap.phoenix.APIdaVida.DTO.ComentarioDTO;
import br.com.fiap.phoenix.APIdaVida.Entity.Comentario;
import br.com.fiap.phoenix.APIdaVida.Service.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService service;
	
	@GetMapping
	public List<ComentarioDTO> getComentarios(){
		return service.getAllComentarios();
	}
	@GetMapping("/{id}")
	public List<ComentarioDTO> getByid(@PathVariable(value = "id") long id){
		return service.getById(id);
	}
	
	@PostMapping
	public String save(@Valid @RequestBody Comentario comentario, BindingResult result) {
		if(result.hasErrors()) {
			return "Houve um error";
		}
		service.save(comentario);
		return  " Comentario Cadastrado com sucesso";
	}
	@PutMapping("/{id}")
	public ResponseEntity<Comentario> updateRelato(@PathVariable long id,
			@Valid @RequestBody  Comentario comentarioDetails){
		
		return service.updateComentario(id, comentarioDetails);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRelato(@PathVariable long id){
		return service.delete(id);
	}
	
}
