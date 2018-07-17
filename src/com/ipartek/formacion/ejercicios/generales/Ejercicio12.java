package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa para codificar o decodificar un texto utilizando el m�todo de
 * cifrado de C�sar. Supondremos que el texto solo contiene letras may�sculas o
 * min�sculas. La letras ser�n las correspondientes al alfabeto ingl�s (26
 * caracteres, excluimos la � y �). En este m�todo de cifrado cada letra del
 * texto se sustituye por otra letra que se encuentra N posiciones adelante en
 * el alfabeto. Se considera que el alfabeto es circular, es decir, la letra
 * siguiente a la �z� es la �a�. Por ejemplo, si N es 3, la �a� se transformar�a
 * en �d�, la �b� en �e�, la �c� en �f�, etc. Ejemplo de cifrado C�sar: si el
 * texto es �casa� y N = 3 el texto cifrado es �fdvd�
 * 
 * Para descifrar un texto se realiza la operaci�n contraria. Se calcula la
 * letra que est� N posiciones por detr�s en el alfabeto. Como el alfabeto es
 * circular, la letra anterior a la �a� es la �z�.
 * 
 * El programa pedir� por teclado un texto, a continuaci�n el valor de N y si
 * queremos codificar o decodificar el texto. Finalmente se mostrar� el texto
 * resultante.
 * 
 * Programa resuelto: Cifrado C�sar en Java
 * 
 * Ejemplo de cifrado C�sar: si el texto es �casa� y N = 3 el texto cifrado es
 * �fdvd�
 * 
 * Para descifrar un texto se realiza la operaci�n contraria. Se calcula la
 * letra que est� N posiciones por detr�s en el alfabeto. Como el alfabeto es
 * circular, la letra anterior a la �a� es la �z�.
 * 
 * El programa pedir� por teclado un texto, a continuaci�n el valor de N y si
 * queremos codificar o decodificar el texto. Finalmente se mostrar� el texto
 * resultante.
 * 
 * Programa resuelto: Cifrado C�sar en Java
 * 
 * 
 * import java.io.IOException; import java.util.Scanner;
 * 
 * @author Curso
 *
 */

public class Ejercicio12 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String texto;
		int codigo;
		char opcion = 0;

		do {
			System.out.println(" Ingrese un texto por favor = ");
			texto = s.nextLine();

		} while (texto.isEmpty());

		do {
			System.out.println(" Ingrese el codigo por favor = ");
			codigo = s.nextInt();

		} while (codigo < 1);
		do {
			s.nextLine();
			System.out.println(" cifrar o desifrar : ");
			try {
				opcion = (char) System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
		if (Character.toUpperCase(opcion) == 'C') {
			System.out.println("Texto cifrado = " + cifradoCesar(texto, codigo));
		} else {
			System.out.println("Texto decifrado = " + descifradoCesar(texto, codigo));
		}

	}

	private static String descifradoCesar(String texto, int codigo) {
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26;
		for (int i = 0; i < texto.length();i++)
		return null;
		return texto;
	}

	private static String cifradoCesar(String texto, int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
