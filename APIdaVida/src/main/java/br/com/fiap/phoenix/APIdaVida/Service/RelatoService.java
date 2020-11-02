package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.DTO.RelatoDTO;
import br.com.fiap.phoenix.APIdaVida.Entity.Relato;
import br.com.fiap.phoenix.APIdaVida.Repository.RelatoRepository;

@Service
public class RelatoService {

	@Autowired
	private RelatoRepository relatoRepo;
	
	public List<RelatoDTO> AllRelatos(){
		
			return RelatoDTO.converter(relatoRepo.findAll());
	}
	public List<RelatoDTO> getById( Long id){
		Optional<Relato> use = relatoRepo.findById(id);

		if(use.isPresent()) {
			return RelatoDTO.converterID(relatoRepo.findById(id));
		}
		return null;
	}
	
	public void save(Relato relato) {
		relatoRepo.save(relato);
	}
	
	
	public ResponseEntity<Relato> updateRelato(long id, Relato relatoDetails){
		
		Relato relato = relatoRepo.getOne(id);
		
		relato.setTema(relatoDetails.getTema());
		relato.setTitulo(relatoDetails.getTitulo());
		relato.setTexto(relatoDetails.getTexto());
		relato.setUsuarioId(relatoDetails.getUsuarioId());
		Relato updated = relatoRepo.save(relato);
		
		return ResponseEntity.ok(updated);
		
	}
	
	public ResponseEntity<?> delete( long id){
		return relatoRepo.findById(id).map(mapper -> {
				relatoRepo.deleteById(id);
				return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
	}
	
}
