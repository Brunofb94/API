package br.com.fiap.phoenix.APIdaVida.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.phoenix.APIdaVida.Entity.Comentario;

public interface ComentarioRepository  extends JpaRepository<Comentario, Long> {

}
