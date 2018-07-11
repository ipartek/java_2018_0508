package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;

/**
 * Programa que lea dos caracteres y compruebe si son iguales.
 */

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {

        System.out.print("Introduzca primer carácter: ");
        char ch1 = (char)System.in.read(); 
        System.in.read();
        System.in.read();
        System.out.print("Introduzca segundo carácter: ");
        char ch2 = (char)System.in.read();
        
		System.out.println("'"+ch1+"' y '"+ch2+"'"+((ch1==ch2)?" son iguales":" son diferentes"));
	
	}

}
