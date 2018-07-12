package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java para convertir un número entero a números romanos
 * @author Curso
 *
 */
public class Ejercicio11 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int n1;
		
		do{  
            System.out.print("Introduce un número entre 1 y 3999: ");
            n1 = teclado.nextInt();
        }while(n1 < 1 || n1 > 3999);
		System.out.println(n1 + " en numeros romanos -> " + convertirANumerosRomanos(n1));
		
		teclado.close();
	}

	public static String convertirANumerosRomanos(int n1) {
		
		int unidades;
		int decenas;
		int centenas;
		int miles;
		String romano="";
		
		//obtenemos cada cifra del número
	      miles = n1 / 1000;
	      centenas = n1 / 100 % 10;
	      decenas = n1 / 10 % 10;
	      unidades = n1 % 10;
	      
	    //calcular los miles
	      for (int i = 0; i < miles; i++) {
	    	  romano = romano + "M";
	      }
	      
	    //calcular las centenas
	      if (centenas == 9) {
	          romano = romano + "CM";
	      } else if (centenas >= 5) {
	                     romano = romano + "D";
	                     for (int i = 6; i <= centenas; i++) {
	                            romano = romano + "C";
	                     }
	      } else if (centenas == 4) {
	                      romano = romano + "CD";
	      } else {
	                  for (int i = 1; i <= centenas; i++) {
	                         romano = romano + "C";
	                  }
	      }
	      
	    //calcular las decenas
	      if (decenas == 9) {
	           romano = romano + "XC";
	      } else if (decenas >= 5) {
	                      romano = romano + "L";
	                      for (int i = 6; i <= decenas; i++) {
	                            romano = romano + "X";
	                      }
	      } else if (decenas == 4) {
	                      romano = romano + "XL";
	      } else {
	                    for (int i = 1; i <= decenas; i++) {
	                           romano = romano + "X";
	                    }
	      }
	      
	    //calcular las unidades
	      if (unidades == 9) {
	           romano = romano + "IX";
	      } else if (unidades >= 5) {
	                      romano = romano + "V";
	                      for (int i = 6; i <= unidades; i++) {
	                             romano = romano + "I";
	                      }
	      } else if (unidades == 4) {
	                      romano = romano + "IV";
	      } else {
	                  for (int i = 1; i <= unidades; i++) {
	                         romano = romano + "I";
	                  }
	      }  
		
		return romano;
	}

}

