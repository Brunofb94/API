package br.com.fiap.phoenix.APIdaVida.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario =  repository.findByEmail(username);
		if (usuario.isPresent()) { return usuario.get();} 
			
		throw new UsernameNotFoundException("Dados invalidos");
	}
	
}
