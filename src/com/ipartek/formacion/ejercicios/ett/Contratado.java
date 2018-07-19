package com.ipartek.formacion.ejercicios.ett;

public class Contratado extends Persona  {
	String nss;
	
	public Contratado() {
		super();
		this.nss = "";
	}

	public Contratado(String dni, String nombre, int salario, String nss) {
		super(dni, nombre, salario);
		this.nss = nss;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	@Override
	public String toString() {
		return super.toString() + "Contratado [nss=" + nss + "]";
	}
	
	void calcularSalario(int salario) {
		salario=salario/2;
	}
	
}
