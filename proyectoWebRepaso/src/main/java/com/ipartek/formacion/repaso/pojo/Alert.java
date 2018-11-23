package com.ipartek.formacion.repaso.pojo;

public class Alert {
	
	private String tipo;
	private String texto;	
	
	public static final String ALERT_PRIMARY = "alert-primary";
	public static final String ALERT_SECONDARY = "alert-secondary";
	public static final String ALERT_SUCCESS = "alert-success";
	public static final String ALERT_DANGER = "alert-danger";
	public static final String ALERT_WARNING = "alert-warning";
	public static final String DEFAULT_TEXT = "Sentimos las molestias pero hemos tenido un error inesperado";
		
	public Alert() {
		super();
		tipo = ALERT_DANGER;
		texto = DEFAULT_TEXT;
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
