package com.ipartek.formacion.youtube.pojo;

public class Alert {
	
	public static final String PRIMARY = "primary";
	public static final String SECONDARY = "secondary";
	public static final String SUCCESS = "success";
	public static final String DANGER = "danger";
	public static final String WARNING = "warning";
	
	private String texto;
	private String tipo;
	
	public Alert() {
		super();
		this.texto = "Sentimos las molestias, hemos tenido un problema.";
		this.tipo = DANGER;
	}

	public Alert(String texto, String tipo) {
		this();
		this.texto = texto;
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Alert [texto=" + texto + ", tipo=" + tipo + "]";
	}
	
}
