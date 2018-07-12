package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso1 3. Pasar de grados centígrados a grados kelvin.El proceso
 *         de<br>
 *         leer grados centígrados se debe repetir mientras que se responda
 *         ‘S’<br>
 *         a la pregunta: Repetir proceso? (S/N) F = 32 + ( 9 * C / 5)<br>
 *
 */
public class Ejercicio3 {
	public static void main(String[] args) throws Exception {
		int temperatura;
		char opcion;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("Introduce una temperatura:");
			temperatura = Integer.parseInt(br.readLine());
			System.out.println("Grados Kelvin ..: " + (temperatura + 273));
			System.out.print("Introducir otra temperatura? (S/N): ");
			opcion = br.readLine().charAt(0);
		} while (opcion == 'S' || opcion == 's');
	}
}
