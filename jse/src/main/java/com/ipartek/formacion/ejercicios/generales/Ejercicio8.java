package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso
 *8. Mostrar los N primeros términos de la serie de Fibonacci
 *c
 */
public class Ejercicio8 {

	public static void main(String[] args) throws Exception {
		int numero;
		int fibo1 = 1;
		int fibo2 = 1;

		System.out.println("Cuantos numeros fibonacci quieres ?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numero = Integer.parseInt(br.readLine());
		for(int i=1;i<=numero;i++){
            System.out.print(fibo2 + " ");
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
       }
	}
}
