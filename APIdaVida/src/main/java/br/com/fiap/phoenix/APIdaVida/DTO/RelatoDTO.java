package br.com.fiap.phoenix.APIdaVida.DTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.phoenix.APIdaVida.Entity.Relato;

public class RelatoDTO {
	
	public RelatoDTO(Relato relato) {
		this.id = relato.getId();
		this.tema = relato.getTema();
		this.titulo = relato.getTitulo();
		this.texto = relato.getTexto();
		this.usuario_id = relato.getUsuarioId().getId();
	}
	
	private Long id;
	private String tema;
	private String titulo;
	private String texto;
	private Long usuario_id;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the tema
	 */
	public String getTema() {
		return tema;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	public static List<RelatoDTO> converter(List<Relato> relatos){
		return relatos.stream().map(RelatoDTO::new).collect(Collectors.toList());
	}
	
	public static List<RelatoDTO> converterID(Optional<Relato> relatos) {
		// TODO Auto-generated method stub
		return relatos.stream().map(RelatoDTO::new).collect(Collectors.toList());
	}
}
