package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/**
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y calcule su número de la suerte.<br>
 * El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a continuación sumando las cifras<br>
 *  obtenidas en la suma.<br>
 *  Por ejemplo:<br>
 *  Si la fecha de nacimiento es 12/07/1980 <br>
 *  Calculamos el número de la suerte así: 12+7+1980 = 1999  1+9+9+9 = 28<br>
 *  Número de la suerte: 28<br>
 * @author Curso
 *
 */
public class Ejercicio13 {
	public static void main(String[] args){
		int dia;
		int mes;
		int anio;
		int num;

		Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dia de nacimiento: "); 
        dia = sc.nextInt();
        System.out.println("Introduce el mes de nacimiento: "); 
        mes = sc.nextInt();
        System.out.println("Introduce el año de nacimiento: "); 
        anio = sc.nextInt();
        System.out.println("Tu fecha de nacimiento es:" + dia + "/" + mes + "/" + anio);
        num=(anio/1000)+((anio/100)%10)+((anio/10)%10)+(anio%10);
        System.out.println(num); 
        System.out.println("Tu numero de la suerte es: " +(dia+mes+num));
 
        sc.close();

	}
}
