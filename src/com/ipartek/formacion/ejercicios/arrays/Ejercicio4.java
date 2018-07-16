package com.ipartek.formacion.ejercicios.arrays;

/**
 * Guardar en un array los 20 primeros números pares
 * 
 * @author andreaperez
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		int[]arrayN=new int[20];
		int cont=2;
		for (int i = 0; i < arrayN.length; i++) {
			arrayN[i]=cont;
			cont+=2;
			System.out.println(arrayN[i]);
		}

	}

}
