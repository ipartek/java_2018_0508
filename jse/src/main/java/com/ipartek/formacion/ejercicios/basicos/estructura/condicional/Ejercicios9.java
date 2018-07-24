package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso1 9. Programa que lea tres números enteros <b>H</b>, <b>M</b>,
 *         <b>S</b> que contienen<br>
 *         hora, minutos y segundos respectivamente, y comprueba si la hora<br>
 *         que indican es una hora válida.
 * 
 */

public class Ejercicios9 {
	private static int[] reglasDias = { 24, 60, 60 };

	public static void main(String[] args) throws Exception {
		int[] vector = { 0, 0, 0 };
		boolean horaCorrecta = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce una hora  :");
		vector[0] = Integer.parseInt(br.readLine());
		System.out.println("Introduce minutos :");
		vector[1] = Integer.parseInt(br.readLine());
		System.out.println("Introduce segundos :");
		vector[2] = Integer.parseInt(br.readLine());
		for (int x = 0; x < vector.length; x++) {
			if (vector[x] < reglasDias[x]) {
				horaCorrecta = true;
			} else {
				horaCorrecta = false;
				break;
			}
		}
		System.out.println(horaCorrecta == true ? "Hora correcta " + vector[0] + ":" + vector[1] + ":" + vector[2]
				: "Hora incorrecta " + vector[0] + ":" + vector[1] + ":" + vector[2]);
	}
}
