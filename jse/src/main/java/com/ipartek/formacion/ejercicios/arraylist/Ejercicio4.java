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

	static ArrayList<String> miStringArrayList;

	public static void main(String[] args) throws Exception {
		miStringArrayList = new ArrayList<String>();
		String resul;
		leerArray(miStringArrayList);
		resul = sacarStringMayor(miStringArrayList);
		System.out
				.println("La mayor cadena de texto introducida es " + resul + " con una longitud de " + resul.length()+" caracteres");
	}

	private static void leerArray(ArrayList<String> miStringArrayList) throws Exception {
		String opcion;
		int contador;

		contador = 0;
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduzca palabras (Para finalizar  escribir FIN)");
			opcion = br.readLine();
			miStringArrayList.add(contador, opcion);
			contador++;
		} while (!opcion.equalsIgnoreCase("FIN"));

	}

	private static String sacarStringMayor(ArrayList<String> miStringArrayList) throws Exception {
		String cademaM = "";
		for (int x = 0; x < miStringArrayList.size(); x++) {
			if (miStringArrayList.get(x).length() > cademaM.length()) {
				cademaM = miStringArrayList.get(x);
			}
		}
		return cademaM;

	}
}
