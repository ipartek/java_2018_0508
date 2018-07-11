package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Curso
 *10. 10. Programa que lee un número de 3 cifras y muestra sus cifras por separado.
 */
public class Ejercicio10 {
public static void main(String[] args) throws Exception{
	System.out.println("Introduce numero de 3 cifras :");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int  numeroc = Integer.parseInt(br.readLine());
}
}
