package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		double radio;
		double longitud, area;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cuantos centimetros tiene de radio tu circulo? ");
		radio = sc.nextDouble();
		longitud = 2*Math.PI*radio;
		//Elevar la potencia al cuadrado
		area = Math.PI*Math.pow(radio, 2);
		
		System.out.println("Tu circulo tiene: " + radio + " cms de radio. Una longitud de: "
				+ longitud + "cms. Y un area de: " + area + " centimetros cuadrados.");
	}

}
