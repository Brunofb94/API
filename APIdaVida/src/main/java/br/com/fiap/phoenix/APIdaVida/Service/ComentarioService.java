package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.Entity.Comentario;
import br.com.fiap.phoenix.APIdaVida.Entity.Relato;
import br.com.fiap.phoenix.APIdaVida.Repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepo;
	
	public List<Comentario> getAllComentarios( ){
		
		return  comentarioRepo.findAll();	
	}
	
	public void save(Comentario comentario) {
		comentarioRepo.save(comentario);
	}
	public ResponseEntity<Comentario> updateComentario(long id, Comentario comentarioDetails){
		
		Comentario comentario = comentarioRepo.getOne(id);
		comentario.setTexto(comentarioDetails.getTexto());
		comentario.setUsuarioId(comentarioDetails.getUsuarioId());
		comentario.setRelatoId(comentarioDetails.getRelatoId());
		comentario.setArtigoId(comentarioDetails.getArtigoId());
		
		Comentario updated = comentarioRepo.save(comentario);
		
		return ResponseEntity.ok(updated);
		
	}
	
	public ResponseEntity<?> delete( long id){
		return comentarioRepo.findById(id).map(mapper -> {
				comentarioRepo.deleteById(id);
				return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
	}
	
}
