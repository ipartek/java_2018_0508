package com.ipartek.ejercicios.estructura.secuencial;
import java.util.*;

/**
 * 2.      Programa Java que lea un nombre y muestre por pantalla:
“Buenos dias nombre_introducido”
 * @author Curso
 *
 */

public class Ejercicio2 {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		String nombre;
		
		System.out.println("Introduce un nombre");
		nombre= sc.nextLine();
		System.out.println("Buenos dias "+nombre);
	}

}
