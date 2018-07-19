package com.ipartek.formacion.ett;

public abstract class Persona {
	
	private String nombre;
	private String dni;
	private int salario;
	
	public Persona() {
		super();
		this.nombre = "";
		this.dni = "";
		this.salario = 0;
	}
	
	public Persona(String nombre, String dni, int salario) {
		this();
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
	}
	
	abstract double calcularSalario();
	
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
	
	public int getSalario() {
		return salario;
	}
	
	public void setSalario(int salario) {
		this.salario = salario;
	}

}
