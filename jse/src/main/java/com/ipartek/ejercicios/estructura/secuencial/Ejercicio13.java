package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, a�o) y calcule su n�mero de la suerte.
El n�mero de la suerte se calcula sumando el d�a, mes y a�o de la fecha de nacimiento y a continuaci�n sumando las cifras obtenidas en la suma.
Por ejemplo:
Si la fecha de nacimiento es 12/07/1980 
Calculamos el n�mero de la suerte as�: 12+7+1980 = 1999  1+9+9+9 = 28
N�mero de la suerte: 28
 * @author Curso
 *
 */

public class Ejercicio13 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		 int dia; 
		 int mes;
		 int ano; 
		 int nsuerte; 
		 int suma; 
		 int cifra1; 
		 int cifra2;
		 int cifra3;
		 int cifra4;
	     System.out.println("Introduzca fecha de nacimiento");
	     System.out.print("d�a: ");
	     dia= sc.nextInt();
	     System.out.print("mes: ");
	     mes= sc.nextInt();
	     System.out.print("a�o: ");
	     ano= sc.nextInt();
	     suma= dia + mes + ano;
	     cifra1= suma/1000;      
	     cifra2= suma/100%10;  
	     cifra3= suma/10%10;  
	     cifra4= suma%10;        
	     nsuerte= cifra1 + cifra2 + cifra3 + cifra4;
	     System.out.println("Su n�mero de la suerte es el: " + nsuerte);
	}

}
