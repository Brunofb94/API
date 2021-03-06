package br.com.fiap.phoenix.APIdaVida.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_artigo")
public class Artigo {


	/**
	 * 
	 */
	public Artigo() {
		super();
	}
	/**
	 * @param id
	 * @param titulo
	 * @param texto
	 * @param usuarioId
	 */
	public Artigo(long id, String titulo, String texto, Usuario usuarioId) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.usuarioId = usuarioId;
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "artigo_seq")
	//@SequenceGenerator(name = "artigo_seq", sequenceName = "artigo_sequence")
	@Column(name = "id_artigo")
	private long id;
	@Column(name = "nm_titulo", length = 200, nullable = false)
	private String titulo;
	@Column(name = "ds_texto", length = 1000, nullable = false)
	private String texto;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
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
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
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
