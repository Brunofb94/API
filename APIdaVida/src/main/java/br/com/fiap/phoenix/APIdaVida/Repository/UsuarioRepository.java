package br.com.fiap.phoenix.APIdaVida.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	
}
