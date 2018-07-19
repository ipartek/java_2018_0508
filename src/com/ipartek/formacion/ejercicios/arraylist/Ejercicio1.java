package com.ipartek.formacion.ejercicios.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa Java que pida por teclado las alturas de N alumnos de una clase
 * y<br>
 * las guarde en un ArrayList de tipo Double. A continuación el programa<br>
 * calculará la altura media de todos los alumnos, cuantos alumnos hay más
 * altos<br>
 * que la media y cuantos más bajos. Para resolverlo vamos a utilizar 4
 * métodos<br>
 * además del método main: Método numeroAlumnos(): este método pide por
 * teclado<br>
 * el número de alumnos de la clase y devuelve dicho número al programa<br>
 * principal. Método leerAlturas(): pide por teclado las alturas de los N<br>
 * alumnos y las almacena en el ArrayList. Este método recibe como parámetros
 * el<br>
 * ArrayList inicialmente vacío y el número de alumnos a leer. Método<br>
 * calcularMedias(): calcula y devuelve la media de los alumnos de la clase.<br>
 * Este método recibe como parámetro el ArrayList con las alturas de todos
 * los<br>
 * alumnos. Método mostrarResultados(): muestra por pantalla todas las alturas
 * y<br>
 * calcula y muestra el número de alumnos con altura superior e inferior a
 * la<br>
 * media. Recibe como parámetros el ArrayList con las alturas de todos los<br>
 * alumnos y la media calculada anteriormente.<br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio1 {
	
	private static Scanner sc = new Scanner(System.in);
	private static int numAlum=0;
	
	public static void main(String[] args) {

		float media;
		
		ArrayList<Float> altura = new ArrayList<Float>();
		
		numAlum = numeroAlumnos();
		leerAlturas(altura, numAlum);

		media = calcularMedia(altura);
		mostrarResultados(altura, media);
		
		sc.close();
	}

	public static int numeroAlumnos() {
		
		do {
			System.out.print("Introduce número de alumnos: ");
			numAlum = sc.nextInt();
		} while (numAlum < 1);
		
		return numAlum;
		
	}

	public static void leerAlturas(ArrayList<Float> a, int numAlum) {

		int i;
		float alto;
		
		for (i = 1; i <= numAlum; i++) {
			do {
				System.out.print("Alumno " + i + " altura: ");
				alto = sc.nextFloat();
			} while (alto <= 0);
			a.add(alto); 
		}
	}

	public static float calcularMedia(ArrayList<Float> a) {
		float media = 0;
		
		for (Float d : a) {
			media = media + d;
		}
		
		return media / a.size();
	}


	public static void mostrarResultados(ArrayList<Float> altura, float media) {
		
		int superior = 0;
		int inferior = 0;
		
		System.out.println("Alturas introducidas: ");
		System.out.println(altura);
		
		for (Float d : altura) {
			if (d > media)
				superior++;
			else if (d < media)
				inferior++;
		}
		
		System.out.printf("Media: %.2f %n", media);
		System.out.println("Hay " + superior + " alumnos más altos que la media");
		System.out.println("Hay " + inferior + " alumnos más bajos que la media");
	}
	
}