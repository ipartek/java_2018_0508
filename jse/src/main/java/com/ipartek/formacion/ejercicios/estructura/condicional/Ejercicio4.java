package com.ipartek.formacion.ejercicios.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea dos caracteres y compruebe si son iguales
 * @author Curso
 *
 */

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {
		
		char car1;
		char car2;
		
		System.out.print("Introduzca primer carácter: ");
        car1 = (char)System.in.read();
        
        System.in.read();  //saltar el intro que ha quedado en el buffer !!IMPORTANTE
        System.in.read();
        
        System.out.print("Introduzca segundo carácter: ");
        car2 = (char)System.in.read();
		
		if(car1 == car2) {
			System.out.println(car1 + " es igual a " + car2);
		}else {
			System.out.println(car1 + " no es igual a " + car2);
		}

	}

}
