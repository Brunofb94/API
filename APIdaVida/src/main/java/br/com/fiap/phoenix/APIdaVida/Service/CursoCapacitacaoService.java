package br.com.fiap.phoenix.APIdaVida.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.phoenix.APIdaVida.Entity.CursoCapacitacao;
import br.com.fiap.phoenix.APIdaVida.Entity.Relato;
import br.com.fiap.phoenix.APIdaVida.Repository.CursoCapacitacaoRepository;

@Service
public class CursoCapacitacaoService {
	
	@Autowired
	private CursoCapacitacaoRepository repository;
	
	public List<CursoCapacitacao> AllCursos(){
		
		return repository.findAll();	
		}

	public void save(CursoCapacitacao c) {
		repository.save(c);
	}
	
	
	public ResponseEntity<CursoCapacitacao> update(long id, CursoCapacitacao c){
		
		
		CursoCapacitacao curso = repository.getOne(id);
		curso.setTitulo(c.getTitulo());
		curso.setDescricao(c.getDescricao());
		curso.setLink(c.getLink());
		curso.setUsuarioId(c.getUsuarioId());
		CursoCapacitacao updated = repository.save(curso);
		
		return ResponseEntity.ok(updated);
		
	}
	
	public ResponseEntity<?> delete( long id){
		return repository.findById(id).map(mapper -> {
				repository.deleteById(id);
				return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
	}

}
