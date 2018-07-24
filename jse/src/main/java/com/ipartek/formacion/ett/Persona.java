package com.ipartek.formacion.ett;
/**
 * 
 * @author Curso
 *
 */
public abstract class Persona {
	
	public Persona() {
		super();
		this.salario = 0;
		this.nombre = "";
		this.dni ="";
	}
	public Persona(int salario, String nombre, String dni) {
		this();
		this.salario = salario;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
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
	int salario;
	String nombre;
	String dni;
	
	abstract void calcularSalario(Persona pojo) ;
	
	@Override
	public String toString() {
		return "Persona [salario=" + salario + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

	
	
}
