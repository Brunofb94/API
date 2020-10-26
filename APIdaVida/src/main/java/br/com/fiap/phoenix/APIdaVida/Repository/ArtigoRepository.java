package br.com.fiap.phoenix.APIdaVida.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.phoenix.APIdaVida.Entity.Artigo;

public interface ArtigoRepository  extends JpaRepository<Artigo, Long> {

}
