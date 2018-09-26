package com.ipartek.formacion.libro.pojo;

public class Alert {
	
	public static final String PRIMARY = "alert-primary";
	public static final String SECONDARY = "alert-secondary";
	public static final String SUCCESS = "alert-success";
	public static final String DANGER = "alert-danger";
	public static final String WARNING = "alert-warning";
	public static final String TEXTO_POR_DEFECTO = "Lo Sentimos pero tenemos un error inexsperado.";
	
	
	private String tipo;
	private String texto;
	
	
	public Alert() {
		super();
		this.tipo = DANGER;
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
