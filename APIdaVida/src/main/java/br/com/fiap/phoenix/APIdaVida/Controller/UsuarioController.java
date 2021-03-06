package br.com.fiap.phoenix.APIdaVida.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import br.com.fiap.phoenix.APIdaVida.DTO.UsuarioDTO;
import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping
	@Cacheable(value = "users")
	public List<UsuarioDTO> getUsuarios() {
			return service.GetAllUsuarios();
	}
	@GetMapping("/{id}")
	public List<UsuarioDTO> getByid(@PathVariable(value = "id") long id){
		return service.getById(id);
	}
	
	@PostMapping
	@CacheEvict(value = "users", allEntries = true)
	public String save2(@Valid @RequestBody Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return "houve um error";
		}
		  service.save(usuario);
		  return "Usuário Cadastrado com sucesso";
		
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value = "users", allEntries = true)
	public ResponseEntity<Usuario> updateUsuario(@PathVariable long id,
			@Valid @RequestBody  Usuario usuarioDetails){
		
		return service.updateUsuario(id, usuarioDetails);
	}
	
	
	@DeleteMapping("/{id}")
	@CacheEvict(value = "users", allEntries = true)
	public ResponseEntity<?> deleteUser(@PathVariable long id){
		return service.delete(id);
	}
	
	

}
