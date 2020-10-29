package br.com.fiap.phoenix.APIdaVida.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Relato {

	

	/**
	 * 
	 */
	public Relato() {
		super();
	}
	
	
	
	/**
	 * @param id
	 * @param tema
	 * @param titulo
	 * @param texto
	 * @param usuarioId
	 */
	public Relato(long id, String tema, String titulo, String texto, Usuario usuarioId) {
		super();
		this.id = id;
		this.tema = tema;
		this.titulo = titulo;
		this.texto = texto;
		this.usuarioId = usuarioId;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "relato_seq")
	//@SequenceGenerator(name = "relato_seq", sequenceName = "relato_sequence", allocationSize = 1)
	@Column(name = "id_relato")
	private long id;
	@Column(name = "nm_tema", length = 200, nullable = false)
	private String tema;
	@Column(name = "nm_titulo", length = 300, nullable = false)
	private String titulo;
	@Column(name = "nm_texto", length = 4000,nullable = false)
	private String texto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario")
	private Usuario usuarioId;	/**
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
	 * @return the tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * @param tema the tema to set
	 */
	public void setTema(String tema) {
		this.tema = tema;
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
