package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

/**
 * Programa que lea dos caracteres y compruebe si son iguales.
 */

import java.io.IOException;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		
		char c1;
		char c2;
		String iguales;
		
		//Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una letra: "); 
        c1 = (char)System.in.read(); 
        System.in.read();
        System.out.println("Introduce otra letra: "); 
        c2 = (char)System.in.read(); 

        if(c1==c2) {
        	iguales="SON IGUALES";
        }else {
        	iguales ="SON distintos";
        }
        
		//String iguales=(c1==c2)?"SON IGUALES":"SON DISTINTOS";

		System.out.println("La letra " + c1 + "y la letra " + c2 + " son: "+ iguales);
		
		//sc.close();
	}
}
