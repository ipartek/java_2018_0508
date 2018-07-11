package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

/**
 * Programa Java que calcule el área de un triángulo en función de las longitudes de sus lados (a, b, c), según la siguiente<br>
 *  fórmula:  <br>
 * Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c))<br>
 * donde p =  (a+b+c)/2<br>
 * Para calcular la raíz cuadrada se utiliza el método Math.sqrt() <br>
 */

import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args){
		
		float ladoa;
		float ladob;
		float ladoc;
		float area;
		float p;
		
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la longitud del primer lado: "); 
        ladoa = sc.nextFloat(); 
        System.out.println("Introduce la longitud del segundo lado: "); 
        ladob = sc.nextFloat();   
        System.out.println("Introduce la longitud del tercer lado: "); 
        ladoc = sc.nextFloat();   
        p=(ladoa+ladob+ladoc)/2;
        area= (float) Math.sqrt(p*(p-ladoa)*(p-ladob)*(p-ladoc));
        System.out.println("El area del triangulo es: " + area);
	}
}
