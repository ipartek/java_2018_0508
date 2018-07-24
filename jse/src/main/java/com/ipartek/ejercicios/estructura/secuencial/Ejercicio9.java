package com.ipartek.ejercicios.estructura.secuencial;
import java.util.Scanner;
/**
 * Programa Java que calcule el área de un triángulo en función de las longitudes de sus lados (a, b, c), según la siguiente fórmula:  
Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))
donde p =  (a+b+c)/2
Para calcular la raíz cuadrada se utiliza el método Math.sqrt() 
 * @author Curso
 *
 */

public class Ejercicio9 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		double a;
		double b;
		double c;
		double p;
		
        System.out.print("Introduce longitud del primer lado del triángulo: ");
        a = sc.nextDouble();
        System.out.print("Introduce longitud del segundo lado del triángulo: ");
        b = sc.nextDouble();
        System.out.print("Introduce longitud del tercer lado del triángulo: ");
        c = sc.nextDouble();
        p = (a+b+c)/2;
        System.out.println("Area: " +  Math.sqrt(p*(p-a)*(p-b)*(p-c)));
		
		
	}

}
