package com.ipartek.formacion.generales;

import java.util.Scanner;

/*
 * Pasar de grados centígrados a grados kelvin.
 * El proceso de leer grados centígrados se debe repetir mientras que se responda ‘S’ 
 * a la pregunta: Repetir proceso? (S/N)
 */
public class Ejercicio2 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
        String line;
        int c;
        float k;
        
        do {
            System.out.println("Introduzca grados centigrados: ");
            c = sc.nextInt();
            
            k = c + 273.15f;
            
            System.out.println(c + " celsius = " + k + " kelvin");
            System.out.println("¿Repetir proceso? S/N");
            line = sc.next();
            
        } while (!line.equalsIgnoreCase("N"));

	}

}
