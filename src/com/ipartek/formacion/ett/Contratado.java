package com.ipartek.formacion.ett;

public class Contratado extends Persona {

	private String nss;
	
	public Contratado() {
		super();
	}
	
	public Contratado(String nss) {
		this();
		this.nss = nss;
	}

	//	GETTERS AND SETTERS
	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	//	OTROS MÉTODOS
	@Override
	float calcularSalario() {
		// TODO Auto-generated method stub
		return (this.getSalario() / 2f);
	}

}
