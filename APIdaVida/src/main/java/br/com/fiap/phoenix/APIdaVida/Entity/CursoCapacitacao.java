package br.com.fiap.phoenix.APIdaVida.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CursoCapacitacao {
	
	
	
	/**
	 * 
	 */
	public CursoCapacitacao() {
		super();
	}
	/**
	 * @param id
	 * @param titulo
	 * @param descricao
	 * @param link
	 * @param usuarioId
	 */
	public CursoCapacitacao(long id, String titulo, String descricao, String link, Usuario usuarioId) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.link = link;
		this.usuarioId = usuarioId;
	}
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cursoCapacitacao_seq")
	@SequenceGenerator(name = "cursoCapacitacao_seq", sequenceName = "cursoCapacitacao_sequence")
	private long id;
	@Column(name = "nm_titulo", length = 200, nullable = false)
	private String titulo;
	@Column(name = "nm_descrisao", length = 1000)
	private String descricao;
	@Column(name = "nm_link", length = 200, nullable = false)
	private String link;
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuarioId;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the usuarioId
	 */
	public Usuario getUsuarioId() {
		return usuarioId;
	}
	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
}
