package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Curso
 *6. Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por teclado.
 *
 /1h = 3600 segundos
  * 1km = 1000 metros
 */
public class Ejercicio6 {
public static void main(String[] args) throws Exception{
	 double longitud;
     double area;
     
     System.out.println("Introduzca La velocidad:");
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     double velocidadKm = Double.parseDouble(br.readLine());
     double velocidadM = (velocidadKm * 1000) / 3600;
     System.out.println("La velocidad de "+ velocidadKm+ "convertida a m/s equivale a : "+velocidadM+" m/s");
}
}
