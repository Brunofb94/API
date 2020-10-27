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

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> getUsuarios(){
		return service.GetAllUsuarios();
	}
	
	@PostMapping
	public String save(@Valid @RequestBody Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return "Houve um error";
		}
		service.createUsuario(usuario);
		return  "Cadastrado com sucesso";
	}
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable long id,
			@Valid @RequestBody  Usuario usuarioDetails){
		
		return service.updateUsuario(id, usuarioDetails);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id){
		return service.delete(id);
	}
	
	

}
