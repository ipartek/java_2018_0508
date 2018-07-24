package com.ipartek.formacion.herencia;
/**
 * ETT, vamos a manejar personas, de todas las personas posibles tiene que haber un metodo
 * que sea calcularSalario(), y tengo que saber su nombre y su DNI. Personas tenemos al
 * contratado, del contratado tmb queremos saber le numero de la seguridad social. Queremos
 * otra persona que sea secretaria y queremos saber la edad. 
 * Socios fundadores: nombre y dni.
 * Salario secretaria: atributo salario*0.8
 * Socio fundador: salario*3
 * Contratado: salario/2
 * 
 * Jerarquia de clases y test para ver que todo funciona
 * Contratado: 600
 * Secretaria: 1000
 * Socio fundador: 5000
 */


public class Empresa {
	
	protected int salario;
	protected String nombre;
	protected String dni;
	
	public Empresa() {
		
		super();
		this.salario=1000;
		this.nombre="";
		this.dni="";
	}
	
	public Empresa(int salario, String nombre, String dni) {
		
		this();
		this.salario=salario;
		this.nombre=nombre;
		this.dni=dni;
		
		
	}
	
	void calcularSalario(){
		
		
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

	@Override
	public String toString() {
		return "Empresa [salario=" + salario + ", nombre=" + nombre + ", dni=" + dni + "]";
	}
	
	


}

