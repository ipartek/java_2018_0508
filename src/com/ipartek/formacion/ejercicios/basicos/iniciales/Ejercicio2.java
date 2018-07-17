package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Programa java que realice lo siguiente: declarar dos variables X e Y de tipo
 * int, dos variables N y M de tipo double y asigna a cada una un valor. A
 * continuación reliza y muestra por pantalla: El valor de cada variable. La
 * suma X + Y La diferencia X – Y El producto X * Y El cociente X / Y El resto X
 * % Y La suma N + M La diferencia N – M El producto N * M El cociente N / M El
 * resto N % M La suma X + N El cociente Y / M El resto Y % M El doble de cada
 * variable La suma de todas las variables El producto de todas las variables
 * 
 * @author Curso
 *
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 15;
		int y = 20;
		double n = 2.5;
		double m = 3.14;

		System.out.println("Variable X: " + x);
		System.out.println("Variable Y: " + y);
		System.out.println("Variable N: " + n);
		System.out.println("Variable M: " + m);

		System.out.println(x + " + " + y + " = " + (x + y));
		System.out.println(x + " - " + y + " = " + (x - y));
		System.out.println(x + " * " + y + " = " + (x * y));
		System.out.println(x + " / " + y + " = " + (x / y));
		System.out.println(x + " % " + y + " = " + (x % y));

		System.out.println(n + " + " + m + " = " + (n + m));
		System.out.println(n + " - " + m + " = " + (n - m));
		System.out.println(n + " * " + m + " = " + (n * m));
		System.out.println(n + " / " + m + " = " + (n / m));
		System.out.println(n + " % " + m + " = " + (n % m));

		System.out.println(x + " + " + n + " = " + (x + n));
		System.out.println(y + " / " + m + " = " + (y / m));
		System.out.println(y + " % " + m + " = " + (y % m));

		System.out.println("Variable X: " + x + "el doble es " + (2 * x));
		System.out.println("Variable Y: " + y + "el doble es " + (2 * y));
		System.out.println("Variable N: " + n + "el doble es " + (2 * n));
		System.out.println("Variable M: " + m + "el doble es " + (2 * m));

		System.out.println(x + " + " + y + " + " + n + " + " + m + " = " + (x + y + n + m));
		System.out.println(x + " * " + y + " * " + n + " * " + m + " = " + (x * y * n * m));
	}

}
