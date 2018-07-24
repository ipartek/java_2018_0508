package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Cifrado Cesar para codificar y decodificar un texto
 *
 *         En este método de cifrado cada letra del texto se sustituye por
 *         otra<br>
 *         letra que se encuentra N posiciones adelante en el alfabeto.<br>
 *         Se considera que el alfabeto es circular, es decir, la letra<br>
 *         siguiente a la ‘z’ es la ‘a’.
 */
public class Ejercicio12 {

	static String charMin = "abcdefghijklmnopqrstuvwxyz";
	static String charMay = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		char opcion;

		do {
			String texto = "";
			int n = 0;
			System.out.println("Introduce el texto");
			texto = bf.readLine();
			System.out.println("Desplazamiento para el cifrado.(numero entero)");
			n = Integer.parseInt(bf.readLine());

			System.out.print("(C) cifrar o (D) descifrar?: ");
			opcion = (char) System.in.read();
			if (Character.toUpperCase(opcion) == 'C') {

				System.out.println(cifCesar(texto, n));

			} else {
				System.out.println(desCifCesar(texto, n));
			}

		} while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');

	}

	private static String cifCesar(String entrada, int desp) {
		String salida = "";
		for (int i = 0; i < entrada.length(); i++) {
			if ((charMin.indexOf(entrada.charAt(i)) != -1) || (charMay.indexOf(entrada.charAt(i)) != -1))
				salida += (charMin.indexOf(entrada.charAt(i)) != -1)
						? charMin.charAt(((charMin.indexOf(entrada.charAt(i))) + desp) % charMin.length())
						: charMay.charAt((charMay.indexOf(entrada.charAt(i)) + desp) % charMay.length());
			else
				salida += entrada.charAt(i);
		}
		return salida;
	}

	private static String desCifCesar(String entrada, int desp) {
		String salida = "";
		for (int i = 0; i < entrada.length(); i++) {
			if ((charMin.indexOf(entrada.charAt(i)) != -1) || (charMay.indexOf(entrada.charAt(i)) != -1))
				salida += (charMin.indexOf(entrada.charAt(i)) != -1)
						? charMin.charAt(((charMin.indexOf(entrada.charAt(i))) - desp) % charMin.length())
						: charMay.charAt((charMay.indexOf(entrada.charAt(i)) - desp) % charMay.length());
			else
				salida += entrada.charAt(i);
		}
		return salida;
	}
}
