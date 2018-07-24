package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.util.Scanner;

/*Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y calcule su número de la suerte.
El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a continuación sumando las cifras obtenidas en la suma.
Por ejemplo:
Si la fecha de nacimiento es 12/07/1980 
Calculamos el número de la suerte así: 12+7+1980 = 1999  1+9+9+9 = 28
Número de la suerte: 28*/
public class Ejercicio13 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Variables
		 int dia, mes, aino, suerte, suma, num1, num2, num3, num4;
		 
		//DATOS
		System.out.println("Introduce tu fecha de cumpleaños:");
		System.out.println("Dia:");
		dia=sc.nextInt();
		System.out.println("Mes:");
		mes=sc.nextInt();
		System.out.println("Año:");
		aino=sc.nextInt();
		
		//CALCULAR NUMERO SUERTE
		suma = dia + mes + aino;
        num1 = suma/1000;      //obtiene la primera cifra
        num2 = suma/100%10;  //obtiene la segunda cifra
        num3 = suma/10%10;   //obtiene la tercera cifra
        num4 = suma%10;        //obtiene la última cifra
        suerte = num1 + num2 + num3 + num4;
		
        System.out.println("El numero de la suerte es:"+suerte);
	}
}
