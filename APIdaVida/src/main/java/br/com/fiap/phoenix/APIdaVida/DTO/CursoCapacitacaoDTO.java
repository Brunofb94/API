package br.com.fiap.phoenix.APIdaVida.DTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.phoenix.APIdaVida.Entity.CursoCapacitacao;

public class CursoCapacitacaoDTO {
	
	public CursoCapacitacaoDTO(CursoCapacitacao cursoCapacitacao) {
		
		this.id = cursoCapacitacao.getId();
		this.titulo = cursoCapacitacao.getTitulo();
		this.descricao = cursoCapacitacao.getDescricao();
		this.link = cursoCapacitacao.getLink();
		this.usuario_id = cursoCapacitacao.getUsuarioId().getId();
	}

	private Long id;
	private String titulo;
	private String descricao;
	private String link;
	private Long usuario_id;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @return the usuario_id
	 */
	public Long getUsuario_id() {
		return usuario_id;
	}
	public static List<CursoCapacitacaoDTO> converter(List<CursoCapacitacao> curso){
		return curso.stream().map(CursoCapacitacaoDTO::new).collect(Collectors.toList());
	}
	public static List<CursoCapacitacaoDTO> converterID(Optional<CursoCapacitacao> c) {
		// TODO Auto-generated method stub
		return c.stream().map(CursoCapacitacaoDTO::new).collect(Collectors.toList());
	}

	
}
