package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.DTO.ComentarioDTO;
import br.com.fiap.phoenix.APIdaVida.Entity.Comentario;
import br.com.fiap.phoenix.APIdaVida.Repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepo;
	
	public List<ComentarioDTO> getAllComentarios( ){
		
		return  ComentarioDTO.converter(comentarioRepo.findAll());	
	}
	public List<ComentarioDTO> getById( Long id){
		Optional<Comentario> use = comentarioRepo.findById(id);

		if(use.isPresent()) {
			return ComentarioDTO.converterID(comentarioRepo.findById(id));
		}
		return null;
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
