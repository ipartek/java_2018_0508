package com.ipartek.formacion.ett;

public abstract class Persona {
	
	private String nombre;
	private String dni;
	private int sueldoBase;
	
	
	
	public Persona() {
		super();
		this.nombre = " ";
		this.dni = " ";
		this.sueldoBase = 0;
	}



	public Persona(String nombre, String dni, int sueldoBase) {
		this();
		this.nombre = nombre;
		this.dni = dni;
		this.sueldoBase = sueldoBase;
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



	public int getSueldoBase() {
		return sueldoBase;
	}



	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}



	abstract int calcularSalario();

	
	
	
	
}
