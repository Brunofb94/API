package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.DTO.UsuarioDTO;
import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public List<UsuarioDTO> GetAllUsuarios(){
		return UsuarioDTO.converter(usuarioRepo.findAll());
	}
	/*public ResponseEntity<Usuario> getById(long id){
		
		Optional<Usuario> user = usuarioRepo.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<Usuario>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}*/
	public List<UsuarioDTO> getById( Long id){
		Optional<Usuario> use = usuarioRepo.findById(id);

		if(use.isPresent()) {
			return UsuarioDTO.converterID(usuarioRepo.findById(id));
		}
		return null;
	}
	public void createUsuario(Usuario usuario) {
		usuarioRepo.save(usuario);
	}
	public String save(Usuario u) {
		
		u.setSenha(encoder.encode(u.getSenha()));
		usuarioRepo.save(u);
		return "Usuário Cadastrado";
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
