package com.ipartek.formacion.ett;

public class EmpresaEtt {

	private double salario;
	private String nombre;
	private String dni;

	public EmpresaEtt() {
		super();

		this.salario = 0;
		this.nombre = "";
		this.dni = "";
	}

	public EmpresaEtt(double salario, String nombre, String dni) {

		this();
		this.salario = salario;
		this.nombre = nombre;
		this.dni = dni;

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "PersonasEtt [salario=" + salario + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
	

}
