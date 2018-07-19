package com.ipartek.formacion.ett;

public abstract class Persona {

	private String nombre;
	private long dni;
	private long sueldoBase;
	
	//Constructores
	
	public Persona() {
		super();
		this.nombre = "";
		this.dni = 0;
		this.sueldoBase = 0;
	}

	public Persona(String nombre, long dni) {
		this();
		this.setNombre(nombre);
		this.setDni(dni);
	}

	//getters and setters
	
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}

	public long getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(long sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", sueldoBase=" + sueldoBase + "]";
	}

	abstract double CalcularSalario ();
}
