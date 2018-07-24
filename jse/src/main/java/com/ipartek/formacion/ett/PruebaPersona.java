package com.ipartek.formacion.ett;

public class PruebaPersona {

	public static void main(String[] args) {
		
		Contratado luis = new Contratado("Luis", "83729104-J", 600, 33);
		
		double salarioLuis = luis.calcularSalario();
		
		System.out.println("El salario de Luis es " + salarioLuis + "€");

		Secretaria asier = new Secretaria("Luis", "83729104-J", 1000, 35);
		
		double salarioAsier = asier.calcularSalario();
		
		System.out.println("El salario de Asier es " + salarioAsier + "€");

		SocioFundador eneko = new SocioFundador("Luis", "83729104-J", 5000);
		
		double salarioEneko = eneko.calcularSalario();
		
		System.out.println("El salario de Eneko es " + salarioEneko + "€");

	}

}
