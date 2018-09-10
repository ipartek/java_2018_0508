package com.ipartek.formacion.nidea.pojo;

public class Alert{
	
	public static final String PRIMARY = "alert-primary";
	public static final String SECONDARY = "alert-secondary";
	public static final String SUCCESS = "alert-success";
	public static final String DANGER = "alert-danger";
	public static final String WARNING = "alert-warning";
	
	public static final String TEXTO_POR_DEFECTO = "Error inesperado sentimos las molestias";
	
	private String tipo;
	private String texto;
	
	public Alert() {
		super();
		this.tipo = DANGER;
		this.texto = TEXTO_POR_DEFECTO;
		
	}
	
	public Alert(String tipo, String texto) {
		this();
		this.setTipo(tipo);
		this.setTexto(texto);
		
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
