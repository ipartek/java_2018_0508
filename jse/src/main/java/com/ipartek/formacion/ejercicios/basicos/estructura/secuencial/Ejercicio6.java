package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
 * teclado.
 * 
 * @author andreaPerez
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.00");
		double km;
		double hora = 3600;

		System.out.print("Ingrese los km/h que desees convertir a m/s: ");
		km = sc.nextDouble();
		System.out.println(km + "/hora son " + df.format(km * 1000 / +hora) + "/s");
		sc.close();
	}

}
