package br.com.fiap.phoenix.APIdaVida.Exception;

public class ErrorFormulario {
	

	/**
	 * @param campo
	 * @param erro
	 */
	public ErrorFormulario(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	private String campo;
	private String erro;
	/**
	 * @return the campo
	 */
	public String getCampo() {
		return campo;
	}
	/**
	 * @param campo the campo to set
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}
	/**
	 * @return the erro
	 */
	public String getErro() {
		return erro;
	}
	/**
	 * @param erro the erro to set
	 */
	public void setErro(String erro) {
		this.erro = erro;
	}
}
