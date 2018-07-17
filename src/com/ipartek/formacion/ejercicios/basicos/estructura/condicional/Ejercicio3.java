package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

/*3. Programa que lea un carácter por teclado y compruebe si es una letra mayúscula*/
public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		//VARIABLES
		char carac;
		
		System.out.println("Introduce un caracter");
		carac=(char)System.in.read(); //lee un solo caracter
		
		  if(Character.isUpperCase(carac)) { //utilizamos el método isUpperCase de la clase Character
	             System.out.println("Es una letra mayúscula");    
		  }else{
	              System.out.println("No es una letra mayúscula");   
	     }
		  /*otra forma de comparar si la letra es mayuscula o minuscula*/
		  
		  /* if(car>='A' && car <='Z')
	           System.out.println("Es una letra mayúscula");    
	        else
	           System.out.println("No es una letra mayúscula");  
		   */
	}
}
