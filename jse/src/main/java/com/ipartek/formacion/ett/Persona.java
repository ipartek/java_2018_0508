package com.ipartek.formacion.ett;

public abstract class Persona {
	//Atributos PADRE
	private String nombre;
	private String dni;
	
	//Constructor padre
	public Persona() {
		super();
		this.nombre=nombre;
		this.dni=dni;
	}
	
	//Tiene una clase abstracta que es salario y depende del hijo cada uno tiene un salario diferente
	  abstract void CalcularSalario();

	@Override
	public String toString() {
		return "--Persona--"+
				"Nombre: "+nombre+
				"Dni: "+dni;
	  
	}
}
