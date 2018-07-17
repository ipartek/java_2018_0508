package com.ipartek.formacion.ejercicios.arraylist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Curso 4. Cadena más larga contenida en un ArrayList de Strings.
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		ArrayList<String> miStringArrayList = new ArrayList();
		String opcion;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduzca palabras hasta que introduzca");
		opcion = br.readLine();
		do {
			miStringArrayList = br.readLine();
		}while()
	}
	private static void leerArray(ArrayList<Integer> miArrayList,int nPosiciones, char opcionRotacion) throws Exception {
		if (opcionRotacion == 'D' || opcionRotacion == 'd') {
			rotarDerecha(miArrayList,nPosiciones);
		}else {
			if (opcionRotacion == 'I' || opcionRotacion == 'i') {
				rotarIzquierda(miArrayList,nPosiciones);
			}
		}
	}
}
