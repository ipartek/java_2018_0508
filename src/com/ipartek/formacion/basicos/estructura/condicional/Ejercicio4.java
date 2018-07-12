package com.ipartek.formacion.basicos.estructura.condicional;

import java.util.Scanner;

/**
 * Programa Java que lea 2 caracteres y compruebe si son iguales.
 * 
 * @author Curso
 *
 */
public class Ejercicio4 {

	static Scanner sc = new Scanner(System.in);
	    
	    public static void main(String args[]) {
	        
	        String c = leerCaracter();
	        String c2 = leerCaracter();
	        System.out.println(c.equals(c2) ? "Los caracteres " + c + ", " + c2 + " son iguales." : "Los caracteres " + c + ", " + c2 + " no son iguales.");
	    }
	    
	    private static String leerCaracter() {
	        
	        System.out.println("Introduce un carácter: ");
	        return sc.next();
	    }

}
