package com.ipartek.formacion.ett;

/**
 * 
 * @author Curso this.salario = salario; this.nombre = nombre; this.dni = dni;
 */
public class sociosFundadores extends Persona {
	static final int  SUELDO = 5000;
	int calculo;

	public sociosFundadores() {
		super();	
	}

	public sociosFundadores(int salario, String nombre, String dni) {
		super(salario, nombre, dni);
	}

	public sociosFundadores(String nSeguridad, int calculo) {
		this();
		this.calculo = calculo;
	}

	public static void main(String[] args) {
		Persona eneko = new sociosFundadores(5000,"Eneko","ESB987654321x");
		eneko.calcularSalario(eneko);
		

			// TODO Auto-generated method stub
			
		}

	@Override void calcularSalario(Persona eneko) {
		int calculo;
		calculo = eneko.getSalario() * 3;
		System.out.println("El salario de luis es: "+ calculo);
		
		
	}

	@Override
	public String toString() {
		return super.toString() + "sociosFundadores [calculo=" + calculo + "]";
	}
}