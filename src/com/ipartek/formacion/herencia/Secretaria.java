package com.ipartek.formacion.herencia;

public class Secretaria extends Empresa {
	
	private int edad;
	
	public Secretaria() {
		
		super();
		this.edad=0;
	}
	
 public Secretaria(int salario, String nombre, String dni, int edad) {
		
		super(salario, nombre, dni);
		this.edad=edad;
		
	}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

@Override
public String toString() {
	return "Secretaria [edad=" + edad + "]";
}
 
 

}
