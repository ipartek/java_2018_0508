package com.ipartek.formacion.basicos.estructura_condicional;

import java.util.Scanner;

/**
 * Programa Java que lea 1 caracter y compruebe si es un número.
 * 
 * @author Curso
 *
 */
public class Ejercicio6 {

	static Scanner sc = new Scanner(System.in);
	    
	    public static void main(String args[]) {
	        
	        char c = leerCaracter().charAt(0);
	
	        System.out.println(Character.isDigit(c) ? "'" + c + "' es un digito." : "'" + c + "' no es un digito.");
	    }
	    
	    private static String leerCaracter() {
	        
	        System.out.println("Introduce un carácter: ");
	        return sc.next();
	    }

}
