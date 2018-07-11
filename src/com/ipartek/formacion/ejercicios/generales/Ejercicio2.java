package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		String respuesta = "no";
		int numero;
		int cifras;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			//Pedimos un numero por pantalla
			System.out.println("Introduce un numero ");
			numero = sc.nextInt();
			
			//Inicializamos el contador a cero
			cifras = 0;
			//Mientras el numero sea diferente de 0 lo vamos dividiendo entre 10 para 
			//quitarle el ultimo digito
			while(numero!=0) {
				numero = numero/10;
				cifras ++;
			}
			System.out.println("El numero tiene: " + cifras + " cifras");
			System.out.println("Desea continuar?");
			respuesta = sc.next();
			
		}while(("si").equals(respuesta));
		
		sc.close();
	}

}
