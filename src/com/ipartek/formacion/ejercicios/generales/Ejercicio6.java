package com.ipartek.formacion.ejercicios.generales;

/**
 * 
 * @author Curso 6. Comprobar si un número es perfecto.
 *i= dividendo que en cada vuelta se incrementa hasta el 1000<br>
 *j= es el divisor que itera tantas veces como el numero de vuelta de i y comprueba si el resto es 0<br>
 *si es asi se van recogiendo la suma de sus divisores para sumarlos y comprobar si coincide con el numero de vuelta i<br>
 *si coinciden es numero perfecto<br>
 *
 */
public class Ejercicio6 {
	public static void main(String[] args) {
		int i, j, suma;
		System.out.println("Números perfectos entre 1 y 1000: ");
		for (i = 1; i <= 1000; i++) { 
			suma = 0;
			for (j = 1; j < i; j++) { 
				if (i % j == 0) {
					suma = suma + j;
				}
			}
			if (i == suma) { 
				System.out.println(i);
			}
		}
	}

}
