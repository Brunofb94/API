package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.Entity.Artigo;
import br.com.fiap.phoenix.APIdaVida.Repository.ArtigoRepository;

@Service
public class ArtigoService {

	@Autowired
	private ArtigoRepository artigoRepo;
	
	public List<Artigo> getAllArtigo(){
		return artigoRepo.findAll();
	}
	
	public void save(Artigo artigo) {
		artigoRepo.save(artigo);
	}
	
	public ResponseEntity<Artigo> updateArtigo(long id, Artigo artigoDetails){
		
		Artigo artigo = artigoRepo.getOne(id);
		
		artigo.setTitulo(artigoDetails.getTitulo());
		artigo.setTexto(artigoDetails.getTexto());
		artigo.setUsuarioId(artigoDetails.getUsuarioId());
		
		Artigo updated = artigoRepo.save(artigo);
		
		return ResponseEntity.ok(updated);
		
	}
	public ResponseEntity<?> delete( long id){
		return artigoRepo.findById(id).map(mapper -> {
				artigoRepo.deleteById(id);
				return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
	}
}
