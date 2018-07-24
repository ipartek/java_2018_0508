package com.ipartek.formacion.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa Java que pide un número entero por teclado y calcula y muestra el
 * número de cifras que <br>
 * tiene.<br>
 * Por ejemplo si se introduce el número 54391 el programa mostrará el
 * mensaje:<br>
 * El número tiene 5 cifras<br>
 * Si se introduce el número 101 se mostrará el mensaje:<br>
 * El número tiene 3 cifras<br>
 * El proceso leer un número y contar sus cifras se repetirá hasta que se
 * conteste ‘N’ a la pregunta <br>
 * Continuar? (S/N)<br>
 * Si se responde 'S' se volverá a pedir otro número. <br>
 * Para saber cuántas cifras tiene un número entero haremos lo siguiente:<br>
 * Dividiremos el número sucesivamente entre 10. En cada división tomaremos la
 * parte entera y <br>
 * volvemos a dividir. Este proceso se repite hasta que se obtenga un cero como
 * cociente en la <br>
 * división.<br>
 * Por ejemplo, si el número leído es 1234 haremos las siguientes
 * operaciones:<br>
 * 1234 / 10 = 123<br>
 * 123 / 10 = 12<br>
 * 12 / 10 = 1<br>
 * 1 / 10 = 0<br>
 * Hemos realizado 4 divisiones hasta obtener un cero como cociente, por lo
 * tanto el número tiene <br>
 * 4 cifras.
 * 
 * @author Ainara
 *
 */

public class Ejercicio2 {
//TODO que pida un numero de manera String y pasarlo a int
	public static void main(String[] args) throws IOException {

		int num;
		int cifras;
		char contestacion;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Introduce un número entero: ");
			num = sc.nextInt();
			cifras = 0; 
			
			while (num != 0) { 
				num = num / 10; 
				cifras++; 
			}
			
			System.out.println("El número introducido tiene " + cifras + " cifras");
			System.out.print("¿Quieres continuar? ");
			contestacion = (char) System.in.read();
		
		} while (contestacion != 'n' && contestacion != 'N');
		sc.close();
	}

}
