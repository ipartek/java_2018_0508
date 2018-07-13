package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.util.*;

/**
 * Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula
 * 
 * @author Curso
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s;
        char c1;
        
        System.out.print("Introduce un carácter: ");
        s = sc.next();
        c1 = s.charAt(0);
        
        
        if(Character.isUpperCase(c1)) 
           System.out.println("Es una letra mayúscula");    
        else
            System.out.println("No es una letra mayúscula");   
		
        sc.close();
	}

}
