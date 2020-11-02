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
@Table(name = "tb_comentario")
public class Comentario {

	/**
	 * 
	 */
	public Comentario() {
		super();
	}
	/**
	 * @param id
	 * @param texto
	 * @param usuarioId
	 * @param relatoId
	 * @param artigoId
	 */
	public Comentario(long id, String texto, Usuario usuarioId, Relato relatoId, Artigo artigoId) {
		super();
		this.id = id;
		this.texto = texto;
		this.usuarioId = usuarioId;
		this.relatoId = relatoId;
		this.artigoId = artigoId;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "comentario_seq")
	//@SequenceGenerator(name = "comentario_seq", sequenceName = "comentario_sequence")
	@Column(name = "id_comentario")
	private long id;
	@Column(name = "ds_texto", length = 500, nullable = false)
	private String texto;
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuarioId;
	@ManyToOne
	@JoinColumn(name = "id_relato")
	private Relato relatoId;
	@ManyToOne
	@JoinColumn(name = "id_artigo")
	private Artigo artigoId;
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
	/**
	 * @return the relatoId
	 */
	public Relato getRelatoId() {
		return relatoId;
	}
	/**
	 * @param relatoId the relatoId to set
	 */
	public void setRelatoId(Relato relatoId) {
		this.relatoId = relatoId;
	}
	/**
	 * @return the artigoId
	 */
	public Artigo getArtigoId() {
		return artigoId;
	}
	/**
	 * @param artigoId the artigoId to set
	 */
	public void setArtigoId(Artigo artigoId) {
		this.artigoId = artigoId;
	}
	
	
	


}
