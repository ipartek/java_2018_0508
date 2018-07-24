package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa que muestre lo siguiente por pantalla: <br>
 * ZYWXVUTSRQPONMLKJIHGFEDCBA<br>
 * YWXVUTSRQPONMLKJIHGFEDCBA<br>
 * WXVUTSRQPONMLKJIHGFEDCBA<br>
 * XVUTSRQPONMLKJIHGFEDCBA<br>
 * VUTSRQPONMLKJIHGFEDCBA<br>
 * UTSRQPONMLKJIHGFEDCBA<br>
 * TSRQPONMLKJIHGFEDCBA<br>
 * SRQPONMLKJIHGFEDCBA<br>
 * RQPONMLKJIHGFEDCBA<br>
 * QPONMLKJIHGFEDCBA<br>
 * PONMLKJIHGFEDCBA<br>
 * ONMLKJIHGFEDCBA<br>
 * NMLKJIHGFEDCBA<br>
 * MLKJIHGFEDCBA<br>
 * LKJIHGFEDCBA<br>
 * KJIHGFEDCBA<br>
 * JIHGFEDCBA<br>
 * IHGFEDCBA<br>
 * HGFEDCBA<br>
 * GFEDCBA<br>
 * FEDCBA<br>
 * EDCBA<br>
 * DCBA<br>
 * CBA<br>
 * BA<br>
 * A<br>
 * 
 * Como podemos ver, en este caso se trata de mostrar las letras del abecedario<br>
 * (sin la Ñ) en mayúsculas y en orden inverso. A continuación en cada fila<br>
 * mostrar una letra menos hasta llegar a mostrar solamente la A.<br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) {

		for (char x = 'Z'; x >= 'A'; x--) {
			for (char y = x; y >= 'A'; y--) {
				System.out.print(y);
			}
			System.out.println();
		}
	}
}
