package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa Java que lea un nombre y muestre por pantalla:<br>
 * “Buenos dias nombre_introducido”<br>
 */

import java.util.Scanner;

public class Ejercicio2 {
	 public static void main(String[] args){
		
	        String nombre;
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Introduce el nombre: "); 
	        nombre = sc.next();      
	        System.out.println("Buenos dias " + nombre);
	        
	        sc.close();
	 }
}
