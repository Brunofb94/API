package br.com.fiap.phoenix.APIdaVida.DTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.phoenix.APIdaVida.Entity.Artigo;

public class ArtigoDTO {

	public ArtigoDTO(Artigo artigo) {
		this.id = artigo.getId();
		this.titulo = artigo.getTitulo();
		this.text = artigo.getTexto();
		this.usuario_id = artigo.getUsuarioId().getId();
	}
	private Long id;
	private String titulo;
	private String text;
	private long usuario_id;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @return the usuario_id
	 */
	public long getUsuario_id() {
		return usuario_id;
	}
	
	public static List<ArtigoDTO> converter(List<Artigo> artigos){
		return artigos.stream().map(ArtigoDTO::new).collect(Collectors.toList());
	}
	public static List<ArtigoDTO> converterID(Optional<Artigo> a) {
		// TODO Auto-generated method stub
		return a.stream().map(ArtigoDTO::new).collect(Collectors.toList());
	}
}
