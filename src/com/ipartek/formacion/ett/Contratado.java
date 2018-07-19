package com.ipartek.formacion.ett;

public class Contratado extends Persona {

	//	VARIABLES DE CLASE
	private String nss;

	// CONSTRUCTORES
	public Contratado() {
		super();
	}

	public Contratado(String nombre, String dni, float salario, String nss) {
		super(nombre, dni, salario);
		this.nss = nss;
	}

	// GETTERS AND SETTERS
	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	// OTROS MÉTODOS
	@Override
	float calcularSalario() {
		// TODO Auto-generated method stub
		return (this.getSalario() / 2f);
	}

}
