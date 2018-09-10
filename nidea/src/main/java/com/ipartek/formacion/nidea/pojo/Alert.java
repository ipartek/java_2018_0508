package com.ipartek.formacion.nidea.pojo;

public class Alert {

	public static final String ALERT_PRIMARY = "alert-primary";
	public static final String ALERT_SECONDARY = "alert-secondary";
	public static final String ALERT_SUCCESS = "alert-success";
	public static final String ALERT_DANGER = "alert-danger";
	public static final String ALERT_WARNING = "alert-warning";

	public static final String TEXT_DANGER = "lo sentimos ha surgido algo inesperado";

	private String tipo;
	private String texto;

	public Alert() {
		super();
		this.tipo = ALERT_DANGER;
		this.texto = TEXT_DANGER;
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


}
