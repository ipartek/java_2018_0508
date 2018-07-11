package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Curso
 *8. Programa que calcula el volumen de una esfera.
 *columen de una esfera
 *   v = 4 * pi * radio³ / 3
 */
public class Ejercicio8 {
public static void main(String[] args) throws Exception {
	
    double volumen;
    System.out.println("Introduce el radio de la esfera:");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double radio = Double.parseDouble(br.readLine());
    
    volumen = (4* Math.PI * (Math.pow(radio,3))) / 3;

    System.out.println("El volumen de la esfera es de : " +volumen+ " M³");
}
}
