package com.ipartek.formacion.ejercicios.basicos.estructura.secuencial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso
 *1. Programa Java que lea dos números enteros por teclado y los muestre por pantalla.
 */
public class Ejercicio1 {
public static void main(String[] args) throws Exception {
    System.out.println("Introduzca el primer numero por pantalla");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //convertimos la entrada a entero directamente
    int uno = Integer.parseInt(br.readLine());
    System.out.println("Introduzca el segundo numero por pantalla");
    int dos = Integer.parseInt(br.readLine());
    System.out.println(uno +" - "+ dos);
}
}
