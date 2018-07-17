package com.ipartek.formacion.ejercicios.arraylist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Curso 3. Rotar los elementos de un ArrayList.
 *
 */
public class Ejercicio3 {
	
	public static void main(String[] args) throws Exception {
		
		int numeroUsuario = 0;
		//String opcionRotacion;
		int nPosiciones;
		int posicionArrayMover = 0;
		int nElementos = 0;
		char opcionRotacion;
		boolean comprobacionDireccion = false;
		ArrayList<Integer> miArrayList = new ArrayList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Cuantos elementos contendra la secuencia de numeros");
		nElementos = Integer.parseInt(br.readLine());
		almacenarSecuencia(miArrayList,nElementos);
		imprimirSecuencia(miArrayList);	
		do {
			System.out.println("Como quiere hacer la rotacion ?");
			System.out.println("Izquierda(I)");
			System.out.println("Derecha(D)");
			System.out.println("Aleatoria(A)");
			opcionRotacion = br.readLine().charAt(0);
			
		} while ( comprobacionDireccion(opcionRotacion) == false);
		do {
			System.out.println("Cuantas posiciones quieres rotar ?");
			nPosiciones =Integer.parseInt(br.readLine()) ;		
		}while (nPosiciones > miArrayList.size());
		
		//posicionArrayMover =  miArrayList.get(nPosiciones).intValue();
		eleccionSolucion(miArrayList,nPosiciones,opcionRotacion);
	}
	private static void imprimirSecuencia(ArrayList<Integer> miArrayList) {
		int secuencia = 0;
		System.out.println("La secuencia introducida es :");
		for (int x = 0; x < miArrayList.size(); x++) {
			System.out.print(miArrayList.get(x) + " ");
		}
		System.out.println("");
		
	}
	private static void almacenarSecuencia(ArrayList<Integer> miArrayList, int nElementos) throws Exception {
		int numero = 0;
		for (int x = 0; x < nElementos; x++) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduzca un numero entero: ");
			numero = Integer.parseInt(br.readLine());
			miArrayList.add(numero) ;

		}
		
	}
	private static boolean comprobacionDireccion(char opcionRotacion) throws Exception {
		/**
		 * funcion que comprueba si el caracter introducido en la seleccion de rotacion
		 * es compatible con las opciones de direccion
		 * devolviendo true si el usuario a tecleado una opcion valida
		 * devolviendo false si no a metido una opcion valida
		 */
		boolean comprobacionDireccion = false;
		if (opcionRotacion == 'I' || opcionRotacion == 'i') {
			comprobacionDireccion = true;
		}else {
			if (opcionRotacion != 'D' || opcionRotacion != 'd') {
				comprobacionDireccion = true;
			}else {
				if (opcionRotacion != 'A' || opcionRotacion != 'a') {
					comprobacionDireccion = true;
				}
			}
		}
		return comprobacionDireccion;
		
	}
	private static void eleccionSolucion(ArrayList<Integer> miArrayList,int nPosiciones, char opcionRotacion) throws Exception {
		if (opcionRotacion == 'D' || opcionRotacion == 'd') {
			rotarDerecha(miArrayList,nPosiciones);
		}else {
			if (opcionRotacion == 'I' || opcionRotacion == 'i') {
				rotarIzquierda(miArrayList,nPosiciones);
			}
		}
	}
	
	private static void rotarDerecha(ArrayList<Integer> miArrayList, int nPosiciones) throws Exception {
		System.out.println("Originalmente la secuencia es :");
		imprimirSecuencia(miArrayList);
		//creo un array con la longitud del nPosiciones
		int [] arrayTemporal = new int[nPosiciones];
		int cont = 0;
		//aqui se desde que punto del arraylist he de extraer para pera insertar posteriormente al inicio del array
		int nextraido = miArrayList.size()-nPosiciones;
		int contador = 0;
		//extraigo los numeros finales que pasaran a formar el inicio del arraylist
		for(int x=nextraido; x < miArrayList.size();x++) {
			
			arrayTemporal[contador]=miArrayList.get(x);
					contador ++;
		}
		//roto los elementos que no pasan al inicio del arraylist
		cont = nextraido-1;
		for (int x= cont;x >= 0;x--) {
			miArrayList.set(x+nPosiciones, miArrayList.get(x).intValue());
		}
		for(int x = 0;x<arrayTemporal.length;x++ ) {
			miArrayList.set(x, arrayTemporal[x]);
		}
		imprimirSecuencia(miArrayList);
	}
	private static void rotarIzquierda(ArrayList<Integer> miArrayList, int nPosiciones) throws Exception {
		System.out.println("En proceso");
		System.out.println("Originalmente la secuencia es :");
		imprimirSecuencia(miArrayList);
		//creo un array con la longitud del nPosiciones
		int [] arrayTemporal = new int[nPosiciones];
		int cont = 0;
		//aqui se desde que punto del arraylist he de extraer para pera insertar posteriormente al inicio del array
		int nextraido = nPosiciones - 1;
		int contador = 0;
		//nextraido representa el conjunto de elementos del array que tenemos que estraer 
		//y recorremos hasta el nPosiciones que nos han indicado
		//AQUI EXTRAIGO EL NUMERO QUE PASARA A LA PARTE TRASERA
		for(int x=nextraido; x < arrayTemporal.length;x++){
			
			arrayTemporal[contador]=miArrayList.get(x) ;
					contador ++ ;
		}
		//roto los elementos que no pasan al inicio del arraylist
		cont = nPosiciones ;
		for (int x= cont;x <= miArrayList.size();x++) {
			miArrayList.set(x-nPosiciones, miArrayList.get(x).intValue());
		}
		for(int x = 0;x<arrayTemporal.length;x++ ) {
			miArrayList.set(x, arrayTemporal[x]);
		}
		imprimirSecuencia(miArrayList);
	}

}
