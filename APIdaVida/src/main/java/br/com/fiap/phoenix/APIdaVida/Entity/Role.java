package br.com.fiap.phoenix.APIdaVida.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nm_name")
	private String name;
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
