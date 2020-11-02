package br.com.fiap.phoenix.APIdaVida.DTO;

public class TokenDTO {

	public TokenDTO(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}
	private String token;
	private String tipo;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	
}
