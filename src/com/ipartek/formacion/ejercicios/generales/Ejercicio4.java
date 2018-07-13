package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 4. Mostrar la tabla de multiplicar de un número. 
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) throws Exception {
		
		int numero ;
		
		System.out.println("Introduce el priemr numero :");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numero =Integer.parseInt(br.readLine());
		System.out.println("La tabla de multiplicar del numero : "+numero);
		for (int x=0;x<=10;x++) {
			System.out.println(numero +" x "+x+": "+numero * x);
		}
	}
}
