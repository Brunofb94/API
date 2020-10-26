package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public List<Usuario> GetAllUsuarios(){
		return usuarioRepo.findAll();
	}
	
	
	public void createUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}
	
	public ResponseEntity<Usuario> updateUsuario( long id, Usuario usuarioDetails){
		
		Usuario usuario  = usuarioRepo.getOne(id);
		
		
		usuario.setNome(usuarioDetails.getNome());
		usuario.setSobrenome(usuarioDetails.getSobrenome());
		usuario.setSenha(usuarioDetails.getSenha());
		usuario.setEspecialidade(usuarioDetails.getEspecialidade());
		usuario.setDocumento(usuarioDetails.getDocumento());
		usuario.setAdmin(usuarioDetails.isAdmin());
		usuario.setAnoFormacao(usuarioDetails.getAnoFormacao());
		usuario.setDataNascimento(usuarioDetails.getDataNascimento());
		usuario.setEmail(usuarioDetails.getEmail());
		
		Usuario updatedUsuario = usuarioRepo.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	
	public ResponseEntity<?> delete( long id){
		return usuarioRepo.findById(id).map(mapper -> {
				usuarioRepo.deleteById(id);
				return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
	}
	
	
}
