/**
 * alertas
 *  tipo danger .> sentimos las molestias se ha producido un error inexperado
 *  constructor con 2 parametros tipo y texto
 *  consturntor vacio 
 *  nuevo enlace con alertas jsp alertas 
 */
package com.ipartek.formacion.nidea.pojo;



public class Alerts {
	public static final String INFO = "alert-primary";
	public static final String SECONDARY = "alert-secondary";
	public static final String SUCESS = "alert-sucess";
	public static final String DANGER = "alert-danger";
	public static final String WARNING = "alert-warning";
	public static final String TEXTO_POR_DEFECTO = "ERROR INEXPERADO";
	private String texto ;
	private String tipo;
	//private String alertTypes[] = {"primary","secondary","sucess","danger","warning"};
	public Alerts() {
		super();
	}
	public Alerts(String texto, String tipo) {
		super();
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
	public static String getInfo() {
		return INFO;
	}
	public static String getSecondary() {
		return SECONDARY;
	}
	public static String getSucess() {
		return SUCESS;
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
	@Override
	public String toString() {
		return "Alerts [texto=" + texto + ", tipo=" + tipo + "]";
	}
}
	
	