package com.ipartek.formacion.ett;
/**
 * 
 * @author Curso
 *this.salario = salario;
		this.nombre = nombre;
		this.dni = dni;
 */
public class Contratado extends Persona {
	static final int  SUELDO = 600;
	String nSeguridad;
	int calculo;

	public Contratado() {
		super();	
	}

	public Contratado(int salario, String nombre, String dni) {
		super(salario, nombre, dni);
	}

	public Contratado(String nSeguridad, int calculo) {
		this();
		this.nSeguridad = nSeguridad;
		this.calculo = calculo;
	}

	public static void main(String[] args) {
		Persona luis = new Contratado(600,"Luis","123456789x");
		luis.calcularSalario(luis);
		

			// TODO Auto-generated method stub
			
		}

	@Override void calcularSalario(Persona luis) {
		int calculo;
		calculo = luis.getSalario() / 2;
		System.out.println("El salario de luis es: "+luis.getSalario() /2);
		
		
	}
	}
	



