package com.ipartek.formacion.ejercicios.ett;

public class Secretaria extends Persona {

	int edad;
	int nss;

	public Secretaria() {
		super();
		this.nss = 0;
	}

	public Secretaria(String dni, String nombre, int salario, int edad, int nss) {
		super(dni, nombre, salario);
		this.edad = edad;
		this.nss = nss;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNss() {
		return nss;
	}

	public void setNss(int nss) {
		this.nss = nss;
	}

	@Override
	public String toString() {
		return super.toString() + "Secretaria [edad=" + edad + ", nss=" + nss + "]";
	}
	
	void calcularSalario(int salario, int edad) {
		salario=salario-edad;
	}

}
