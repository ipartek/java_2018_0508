package com.ipartek.formacion.entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class EntradaEstandar {

	static Reader entrada; // Leemos carácter a carácter

	static BufferedReader bf; // Leemos String

	static String linea; // Iremos guardando línea a línea

	public static void main(String args[]) {

		entrada = new InputStreamReader(System.in); // Leemos carácter a carácter

		bf = new BufferedReader(entrada); // Leemos String y no carácteres

		int n1 = -1;
		int n2 = -1;
		int res = 0;

		float f1 = -1f;
		float f2 = -1f;
		float resF = 0f;

		String nombre = "";

		try {
			do { // Leer Entero 1

				System.out.print("Operando Entero 1: ");
				n1 = leerInt(bf.readLine());

			} while (n1 < 0);

			do { // Leer Entero 1

				System.out.print("Operando Entero 2: ");
				n2 = leerInt(bf.readLine());

			} while (n2 < 0);

			res = n1 + n2;
			System.out.println("Resultado: " + n1 + " + " + n2 + " = " + res);

			do { // Leer Flotante 1

				System.out.print("Operando flotante 1: ");
				f1 = leerFloat(bf.readLine());

			} while (f1 < 0f);

			do { // Leer Flotante 2

				System.out.print("Operando flotante 2: ");
				f2 = leerFloat(bf.readLine());

			} while (f2 < 0f);

			resF = f1 + f2;
			System.out.println("Resultado: " + f1 + " / " + f2 + " = " + resF);

			System.out.print("Introduzca su nombre: ");
			nombre = leerString(bf.readLine()); // Leer nombre

			System.out.println("¡Hola " + nombre + ", bienvenido a Java!");

		} catch (IOException e1) {

			System.out.println("ERROR: " + e1.getMessage());
		}

	} // FIN main();

	/**
	 * 
	 * @param mensaje, String
	 * @return -1 si el mensaje no es un entero
	 */
	public static int leerInt(String mensaje) {
		int valor = -1;

		try {

			valor = Integer.parseInt(mensaje);

		} catch (NumberFormatException e) {

			System.out.println("ERROR: El valor introducido no es correcto.");
		}

		return valor;

	} // FIN leerInt();

	public static float leerFloat(String mensaje) {
		float valor = -1f;

		try {

			valor = Float.parseFloat(mensaje);

		} catch (NumberFormatException e) {

			System.out.println("ERROR: El valor introducido no es correcto.");
		}

		return valor;

	} // FIN leerFloat();

	public static String leerString(String mensaje) {

		return mensaje;
	}

}
