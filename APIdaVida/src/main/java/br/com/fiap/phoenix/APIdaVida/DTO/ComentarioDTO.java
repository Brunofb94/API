package br.com.fiap.phoenix.APIdaVida.DTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.phoenix.APIdaVida.Entity.Comentario;

public class ComentarioDTO {
	
	public ComentarioDTO(Comentario comentario) {
		this.id = comentario.getId();
		this.texto = comentario.getTexto();
		this.usuario_id = comentario.getUsuarioId().getId();
		this.relato_id = comentario.getRelatoId().getId();
		this.artigo_id = comentario.getArtigoId().getId();
	}
	
	private Long id;
	private String texto;
	private Long usuario_id;
	private Long relato_id;
	private Long artigo_id;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @return the usuario_id
	 */
	public Long getUsuario_id() {
		return usuario_id;
	}
	/**
	 * @return the relato_id
	 */
	public Long getRelato_id() {
		return relato_id;
	}
	/**
	 * @return the artigo_id
	 */
	public Long getArtigo_id() {
		return artigo_id;
	}
	public static List<ComentarioDTO> converter(List<Comentario> comentarios){
		return comentarios.stream().map(ComentarioDTO::new).collect(Collectors.toList());
	}
	public static List<ComentarioDTO> converterID(Optional<Comentario> c) {
		// TODO Auto-generated method stub
		return c.stream().map(ComentarioDTO::new).collect(Collectors.toList());
	}
}
