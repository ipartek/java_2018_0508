package com.ipartek.formacion.ejercicios;

import java.util.Scanner;
import java.util.ArrayList;

public class Exercises {

	// Ejercicios Básicos iniciales para principiantes
	// -------------------------------------
	/*
	 * 1. Programa java que realice lo siguiente: declarar una variable N de tipo
	 * int, una variable A de tipo double y una variable C de tipo char y asigna a
	 * cada una un valor. A continuación muestra por pantalla: El valor de cada
	 * variable, la suma de N + A, la diferencia de A - N, el valor numérico
	 * correspondiente al carácter que contiene la variable C.
	 */
	public static void initExercise1() {
		int N = 2;
		double A = 3;
		char C = 'C';
		System.out.println("N: " + N);
		System.out.println("A: " + A);
		System.out.println("C: " + C);
		System.out.println("N+A: " + (N + A));
		System.out.println("A-N: " + (A - N));
		System.out.println("N: " + (int) C);
	}

	/*
	 * 2. Programa java que realice lo siguiente: declarar dos variables X e Y de
	 * tipo int, dos variables N y M de tipo double y asigna a cada una un valor. A
	 * continuación reliza y muestra por pantalla una serie de operaciones entre
	 * ellas.
	 */
	public static void initExercise2() {
		int X = 2;
		int Y = 3;
		double N = 4;
		double M = 5;
		System.out.println(X + Y);
		System.out.println(N * M);

	}

	/*
	 * 3. Programa Java que declare una variable entera N y asígnale un valor. A
	 * continuación escribe las instrucciones que realicen lo siguiente: Incrementar
	 * N en 77, Decrementarla en 3, Duplicar su valor.
	 */
	public static void initExercise3() {

		int N = 3;
		System.out.println(N += 77);
		System.out.println(N -= 3);
		System.out.println(N *= 2);
	}

	/*
	 * 4. Programa java que declare cuatro variables enteras A, B, C y D y asígnale
	 * un valor acada una. A continuación realiza las instrucciones necesarias para
	 * que: B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome
	 * el valor de B.
	 */
	public static void initExercise4() {

		int A = 1;
		int B = 2;
		int C = 3;
		int D = 4;
		int B_tmp = B;
		B = C;
		C = A;
		A = D;
		D = B_tmp;
	}

	/*
	 * 5. Programa Java que declare una variable A de tipo entero y asígnale un
	 * valor. A continuación muestra un mensaje indicando si A es par o impar.
	 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
	 */
	public static void initExercise5() {

		int num = 5;
		System.out.println((num % 2 == 0) ? "PAR" : "IMPAR");
	}

	/*
	 * 6. Programa Java que declare una variable B de tipo entero y asígnale un
	 * valor. A continuación muestra un mensaje indicando si el valor de B es
	 * positivo o negativo. Consideraremos el 0 como positivo. Utiliza el operador
	 * condicional (? : ) dentro del println para resolverlo.
	 */
	public static void initExercise6() {

		int B = 3;
		System.out.println((B < 0) ? "negativo" : "positivo");
	}

	/*
	 * 7. Programa Java que declare una variable C de tipo entero y asígnale un
	 * valor. A continuación muestra un mensaje indicando si el valor de C es
	 * positivo o negativo, si es par o impar, si es múltiplo de 5, si es múltiplo
	 * de 10 y si es mayor o menor que 100. Consideraremos el 0 como positivo.
	 * Utiliza el operador condicional ( ? : ) dentro del println para resolverlo.
	 */
	public static void initExercise7() {

		int C = 5;
		System.out.println((C < 0) ? "negativo" : "positivo");
		System.out.println((C % 10 == 0) ? "Es múltiplo de 10" : "No es múltiplo de 10");
		System.out.println((C < 100) ? "Menor que 100" : "Mayor que 100");

	}

	// Ejercicios Básicos con Estructura
	// Secuencial-------------------------------------

	/*
	 * 1. Programa Java que lea dos números enteros por teclado y los muestre por
	 * pantalla.
	 */
	public static void secuencialExercise1() {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca el primer número: ");
		int x = teclado.nextInt();

		System.out.print("Introduzca el segundo número: ");
		int y = teclado.nextInt();

		System.out.println(x + " - " + y);
		teclado.close();

	}

	/*
	 * 2. Programa Java que lea un nombre y muestre por pantalla: “Buenos dias
	 * nombre_introducido”.
	 *
	 */
	public static void secuencialExercise2() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca su nombre: ");
		String nom = teclado.next();

		System.out.println("Buenos dias " + nom);
		teclado.close();

	}

	/*
	 * 3. Programa Java que lee un número entero por teclado y obtiene y muestra por
	 * pantalla el doble y el triple de ese número.
	 */
	public static void secuencialExercise3() {
		Scanner teclado = new Scanner(System.in);

		System.out.print("Introduzca el número: ");
		int num = teclado.nextInt();
		System.out.println("El doble: " + num * 2);
		System.out.println("El triple: " + num * 3);
		teclado.close();
	}

	/*
	 * 4. Programa que lea una cantidad de grados centígrados y la pase a grados
	 * Fahrenheit. La fórmula correspondiente es: F = 32 + ( 9 * C / 5)
	 */
	public static void secuencialExercise4() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca los grados: ");
		float degrees = teclado.nextFloat();
		System.out.print("Grados Fahrenheit: " + (32 + (9 * degrees / 5)));
		teclado.close();
	}

	/*
	 * 5. Programa que lee por teclado el valor del radio de una circunferencia y
	 * calcula y muestra por pantalla la longitud y el área de la circunferencia.
	 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =
	 * PI*Radio^2
	 * 
	 */
	public static void secuencialExercise5() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el radio:  ");
		float radius = teclado.nextFloat();
		System.out.println("Longitud: " + 2 * Math.PI * radius);
		System.out.println("Area de la circunferencia: " + Math.pow(Math.PI * radius, 2));
		teclado.close();
	}

	/*
	 * 6. Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
	 * teclado.
	 */
	public static void secuencialExercise6() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca la velocidad (km/h):  ");
		float velocity = teclado.nextFloat();
		System.out.println("Velocidad: " + velocity * 1000 + "m/s");
		teclado.close();

	}

	/*
	 * 7. Programa lea la longitud de los catetos de un triángulo rectángulo y
	 * calcule la longitud de la hipotenusa según el teorema de Pitágoras.
	 * 
	 */
	public static void secuencialExercise7() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Longitud cateto 1:  ");
		float side1 = teclado.nextFloat();
		System.out.print("Longitud cateto 2:  ");
		float side2 = teclado.nextFloat();

		System.out.println("La hipotenusa es : " + Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2)));
		teclado.close();

	}

	/*
	 * 8. Programa que calcula el volumen de una esfera.
	 */
	public static void secuencialExercise8() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca el radio de una esfera:  ");
		float radius = teclado.nextFloat();
		System.out.println("El volumen es : " + (4.0f / 3.0f) * Math.PI * Math.pow(radius, 3));
		teclado.close();

	}

	/*
	 * 9. Programa que calcula el área de un triángulo a partir de la longitud de
	 * sus lados.
	 */
	public static void secuencialExercise9() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Lado 1:  ");
		float a = teclado.nextFloat();
		System.out.print("Lado 2:  ");
		float b = teclado.nextFloat();
		System.out.print("Lado 3:  ");
		float c = teclado.nextFloat();
		float s = (a + b + c) / 2;
		System.out.println("El area es : " + Math.sqrt(s * (s - a) * (s - b) * (s - c)));
		teclado.close();

	}

	/*
	 * 10. Programa que lee un número de 3 cifras y muestra sus cifras por separado.
	 */

	public static void secuencialExercise10() {
		boolean numSize = false;
		int num = 0;
		final int NUM_OF_DIGITS = 3;
		Scanner teclado = new Scanner(System.in);

		while (!numSize) {
			System.out.print("Numero de tres cifras: ");
			num = teclado.nextInt();
			numSize = (Integer.toString(num).length() == NUM_OF_DIGITS) ? true : false;
		}
		System.out.print("Sus cifras son : ");
		int resto = 0;
		ArrayList<Integer> values = new ArrayList<>();
		while (num > 0) {
			resto = num % 10;
			num /= 10;
			values.add(resto);
		}
		for (int j = values.size() - 1; j >= 0; j--) {
			System.out.print(values.get(j) + " ");
		}
		teclado.close();
	}

	/*
	 * 11. Programa que lea un número entero N de 5 cifras y muestre sus cifras
	 * desde el principio como en el ejemplo.
	 */
	public static void secuencialExercise11() {
		boolean numSize = false;
		int num = 0;
		final int NUM_OF_DIGITS = 5;
		Scanner teclado = new Scanner(System.in);
		while (!numSize) {
			System.out.print("Numero de cinco cifras: ");
			num = teclado.nextInt();
			numSize = (Integer.toString(num).length() == NUM_OF_DIGITS) ? true : false;
		}
		System.out.print("Sus cifras son : ");
		int resto = 0;
		ArrayList<Integer> values = new ArrayList<>();
		while (num > 0) {
			resto = num % 10;
			num /= 10;
			values.add(resto);
		}
		for (int j = values.size() - 1; j >= 0; j--) {
			System.out.print(values.get(j) + " ");
		}
		teclado.close();

	}

	/*
	 * 12. Programa que lea un número entero N de 5 cifras y muestre sus cifras
	 * desde el final igual que en el ejemplo.
	 */
	public static void secuencialExercise12() {
		boolean numSize = false;
		int num = 0;
		final int NUM_OF_DIGITS = 5;
		Scanner teclado = new Scanner(System.in);
		while (!numSize) {
			System.out.print("Numero de cinco cifras: ");
			num = teclado.nextInt();
			numSize = (Integer.toString(num).length() == NUM_OF_DIGITS) ? true : false;
		}
		System.out.print("Sus cifras son : ");
		int resto = 0;
		while (num > 0) {
			resto = num % 10;
			num /= 10;
			System.out.print(resto + " ");
		}
		teclado.close();

	}

	/*
	 * 13. Programa que calcula el número de la suerte de una persona a partir de su
	 * fecha de nacimiento.
	 */
	public static void secuencialExercise13() {

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca la fecha de su nacimiento (dd/mm/year):  ");
		String[] date = teclado.next().split("/");
		int sum = 0;
		int result = 0;
		for (String value : date) {
			sum += Integer.parseInt(value);
		}
		while (sum > 0) {
			result += sum % 10;
			sum /= 10;
		}
		System.out.print("El resultado es: " + result);

	}

	public static void main(String[] args) {
		secuencialExercise13();

	}

}
