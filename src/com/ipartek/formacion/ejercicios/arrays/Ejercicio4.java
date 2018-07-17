package com.ipartek.formacion.ejercicios.arrays;
/**
 * 
 * @author Curso
 * 4. Guardar en un array los 20 primeros números pares
 */
public class Ejercicio4 {
	public static int [] miArray;

	public static void main(String[] args) {
		miArray = new int[20];
		int contador = 0;
		for (int x = 1; x <= 80;x++) {
			if(x%2==0) {
				if(contador < 20) {
					miArray[contador] = x;
					System.out.println(miArray[contador]);
					contador += 1;
				}
				
			}
		}
	}
}
