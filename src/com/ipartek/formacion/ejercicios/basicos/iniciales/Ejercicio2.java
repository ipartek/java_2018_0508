package com.ipartek.formacion.ejercicios.basicos.iniciales;

/**
 * Escribe un programa Java que realice lo siguiente: declarar dos variables X e
 * Y de tipo int, dos variables N y M de tipo double y asigna a cada una un
 * valor. A continuación muestra por pantalla: 
 * El valor de cada variable. La
 * suma X + Y 
 * La diferencia X – Y 
 * El producto X * Y 
 * El cociente X / Y 
 * El resto X % Y 
 * La suma N + M 
 * La diferencia N – M 
 * El producto N * M 
 * El cociente N / M 
 * El resto N % M 
 * La suma X + N 
 * El cociente Y / M 
 * El resto Y % M 
 * El doble de cada variable 
 * La suma de todas las variables 
 * El producto de todas las variables Si por ejemplo le hemos dado a 
 * X el valor 1, a Y el valor 2, a M el valor 3.2 y
 * a N el valor 4.7
 * 
 * @author Curso
 *
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		int X;
		int Y;
		double M;
		double N;

		double suma;
		double resta;
		double producto;
		double cociente;
		double resto;

		double suma2;
		double resta2;
		double producto2;
		double cociente2;
		double resto2;

		double suma3;
		double cociente3;
		double resto3;

		double dobleX;
		double dobleY;
		double dobleM;
		double dobleN;

		double sumaTotal;
		double productoTotal;

		X = 1;
		Y = 2;
		M = 3.2;
		N = 4.7;

		suma = X + Y;
		resta = X - Y;
		producto = X * Y;
		cociente = X / Y;
		resto = X % Y;

		suma2 = N + M;
		resta2 = N - M;
		producto2 = N * M;
		cociente2 = N / M;
		resto2 = N % M;

		suma3 = X + N;
		cociente3 = Y / M;
		resto3 = Y % M;

		dobleX = 2 * X;
		dobleY = 2 * Y;
		dobleM = 2 * M;
		dobleN = 2 * N;

		sumaTotal = X + Y + M + N;
		productoTotal = X * Y * M * N;

		System.out.println("La suma de X + Y: " + suma);
		System.out.println("La resta de X - Y: " + resta);
		System.out.println("El producto de X * Y: " + producto);
		System.out.println("El cociente de X / Y: " + cociente);
		System.out.println("El resto de X % Y: " + resto);

		System.out.println("La suma de M + N: " + suma2);
		System.out.println("La resta de M - N: " + resta2);
		System.out.println("El producto de M * N: " + producto2);
		System.out.println("El cociente de M / N: " + cociente2);
		System.out.println("El resto de N % M: " + resto2);

		System.out.println("La suma de X + N: " + suma3);
		System.out.println("El cociente de Y / M: " + cociente3);
		System.out.println("El resto de Y % M: " + resto3);

		System.out.println("El doble de X: " + dobleX);
		System.out.println("El doble de Y: " + dobleY);
		System.out.println("El doble de M: " + dobleM);
		System.out.println("El doble de N: " + dobleN);

		System.out.println("La suma total: " + sumaTotal);
		System.out.println("El producto total: " + productoTotal);
	}

}
