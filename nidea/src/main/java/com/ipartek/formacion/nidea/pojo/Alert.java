package com.ipartek.formacion.nidea.pojo;


public class Alert {
	
	private String tipo;
	private String texto;

	static public final String PRIMARY_TYPE = "alert-primary";
	static public final String SECONDARY_TYPE = "alert-secondary";
	static public final String SUCCESS_TYPE = "alert-success";
	static public final String DANGER_TYPE = "alert-danger";
	static public final String WARNING_TYPE = "alert-warning";
	static public final String TEXTO_POR_DEFECTO = "Lo sentimos, pero ha ocurrido un fallo inesperado.";
	
	public Alert() {
		super();
		this.tipo = DANGER_TYPE;
		this.texto = TEXTO_POR_DEFECTO;
	}
	
	public Alert(String tipo, String texto) {
		this();
		this.tipo = tipo;
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Alert [tipo=" + tipo + ", texto=" + texto + "]";
	}
	
}
