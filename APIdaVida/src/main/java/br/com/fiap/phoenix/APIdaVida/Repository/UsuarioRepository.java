package br.com.fiap.phoenix.APIdaVida.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
 Optional<Usuario>  findByEmail(String email);
}
