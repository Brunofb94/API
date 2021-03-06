package br.com.fiap.phoenix.APIdaVida.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	/**
	 * @param id
	 * @param nome
	 * @param sobrenome
	 * @param dataNascimento
	 * @param documento
	 * @param anoFormacao
	 * @param especialidade
	 * @param admin
	 * @param email
	 * @param senha
	 */
	public Usuario(Long id, String nome, String sobrenome, Date  dataNascimento, String documento, int anoFormacao,
			String especialidade, boolean admin, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.documento = documento;
		this.anoFormacao = anoFormacao;
		this.especialidade = especialidade;
		this.admin = admin;
		this.email = email;
		this.senha = senha;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "usuario_seq")
	//@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_sequence", allocationSize = 1)
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "nm_nome", length = 100, nullable = false)
	@NotEmpty 
	@NotNull
	private String nome;
	
	@Column(name = "nm_sobrenome", length = 200, nullable = false)
	@NotEmpty @NotNull
	private String sobrenome;
	
	@Column(name = "dt_Nascimento")
	private Date dataNascimento;
	
	@Column(name = "ds_documento", length = 50, nullable = false)
	@NotEmpty @NotNull
	private String documento;
	
	@Column(name ="dt_anoformacao", nullable = false)
	private int anoFormacao;
	
	@Column(name = "ds_especialidade", length = 100, nullable = false)
	@NotEmpty @NotNull
	private String especialidade;
	
	@Column(name = "bt_admin")
	private boolean admin;
	
	@Column(name = "ds_email", length = 200)
	@NotEmpty @NotNull @Email
	private String email;
	@Column(name = "ds_senha", length = 100)
	@NotEmpty @NotNull
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();
	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * @return the anoFormacao
	 */
	public int getAnoFormacao() {
		return anoFormacao;
	}
	/**
	 * @param anoFormacao the anoFormacao to set
	 */
	public void setAnoFormacao(int anoFormacao) {
		this.anoFormacao = anoFormacao;
	}
	/**
	 * @return the especialidade
	 */
	public String getEspecialidade() {
		return especialidade;
	}
	/**
	 * @param especialidade the especialidade to set
	 */
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
