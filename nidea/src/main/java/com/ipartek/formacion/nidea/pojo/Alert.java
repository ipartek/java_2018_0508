package com.ipartek.formacion.nidea.pojo;

public class Alert {
	
	public static final String PRIMARY = "alert-primary";
	public static final String SECONDARY = "alert-secondary";
	public static final String SUCCESS = "alert-success";
	public static final String DANGER = "alert-danger";
	public static final String WARNING = "alert-warning";
	
	public static final String TEXTO_POR_DEFECTO = "Lo sentimos pero tenemos un error inesperado";
	
	private String texto;
	private String tipo;
	
	public Alert() {
		super();
		this.tipo=DANGER;
		this.texto=TEXTO_POR_DEFECTO;
	}

	public Alert(String texto, String tipo) {
		this();
		this.texto=tipo;
		this.tipo=texto;
	}

	public static String getPrimary() {
		return PRIMARY;
	}

	public static String getSecondary() {
		return SECONDARY;
	}

	public static String getSuccess() {
		return SUCCESS;
	}

	public static String getDanger() {
		return DANGER;
	}

	public static String getWarning() {
		return WARNING;
	}

	public static String getTextoPorDefecto() {
		return TEXTO_POR_DEFECTO;
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

	