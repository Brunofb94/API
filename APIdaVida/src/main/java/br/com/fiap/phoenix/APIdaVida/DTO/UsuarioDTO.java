package br.com.fiap.phoenix.APIdaVida.DTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;



public class UsuarioDTO {
	
	public UsuarioDTO(Usuario usuario) {
		
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.dataNascimento = usuario.getDataNascimento();
		this.documento = usuario.getDocumento();
		this.anoFormacao = usuario.getAnoFormacao();
		this.especialidade = usuario.getEspecialidade();
		this.email  = usuario.getEmail();
	}

	private Long id;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private String documento;
	private int anoFormacao;
	private String especialidade;
	private String email;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * @return the anoFormacao
	 */
	public int getAnoFormacao() {
		return anoFormacao;
	}
	/**
	 * @return the especialidade
	 */
	public String getEspecialidade() {
		return especialidade;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	public static List<UsuarioDTO> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
	
	public static List<UsuarioDTO> converterID(Optional<Usuario> usuarios) {
		// TODO Auto-generated method stub
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
}
