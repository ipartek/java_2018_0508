package com.ipartek.formacion.ett;

/**
 * 
 * @author Curso this.salario = salario; this.nombre = nombre; this.dni = dni;
 */
public class Secretaria extends Persona {

	static final int  SUELDO = 800;
	int calculo;
	int edad;

	public Secretaria() {
		super();	
	}

	public Secretaria(int salario, String nombre, String dni) {
		super(salario, nombre, dni);
	}

	public Secretaria(String nSeguridad, int calculo) {
		this();
		this.calculo = calculo;
	}

	public static void main(String[] args) {
		Persona asier = new sociosFundadores(5000,"Asier","ESB987654321x");
		asier.calcularSalario(asier);

			
		}

	@Override void calcularSalario(Persona asier) {
		int calculo;
		calculo = asier.getSalario() * 3;
		System.out.println("El salario de  "+asier.getNombre() +" es: "+ calculo);
		
		
	}

	@Override
	public String toString() {
		return super.toString() + "sociosFundadores [calculo=" + calculo + "]";
	}
}


