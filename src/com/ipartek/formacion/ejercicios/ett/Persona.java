package com.ipartek.formacion.ejercicios.ett;

public class Persona {
	private String dni;
	private String nombre;
	private int salario;

	public Persona(){
		super();
		this.dni="";
		this.nombre = "";
		this.salario=0;

	}
	
	public Persona(String dni, String nombre,int salario) {
		this();
		this.setDni(dni);
		this.setNombre(nombre);
		this.setSalario(salario);
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", salario=" + salario + "]";
	}
	


	

	
}
