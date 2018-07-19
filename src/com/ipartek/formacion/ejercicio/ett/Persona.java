package com.ipartek.formacion.ejercicio.ett;

/*
 * Crear una ett vamos a manejar personas, solo interesa la pasta
 * 
 * Persona -> nombre y DNI, salario
 * Persona contratada => numero ss Ej. Luis 600€ => 300€
 * Persona secretaria => edad Ej. Asier 1000€ => 800€ - edad
 * Socios fundadores => nombre y dni Ej, 5000€ => 15000€
 * 
 * Todas las personas tienen que tener CalcularSalario():
 * Secretaria => salario/0.8
 * Socio fundador => salario*3
 * Contratado => salario/2
 * 
 * Jerarquia de clases y un test JUnit para hacer las pruebas
 */
public abstract class Persona {

	protected String nombre;
	protected String dni;
	protected double salario;
	
	public Persona() {
		super();
	}

	public Persona(String nombre, String dni, double salario) {
		super();
		this.nombre = nombre;
		this.dni = dni;
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
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", salario=" + salario + "]";
	}
	
	public abstract double calcularSalario();
}
