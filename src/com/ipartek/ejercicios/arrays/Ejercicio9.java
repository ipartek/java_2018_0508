package com.ipartek.ejercicios.arrays;

import java.util.Random;

/**
 * Llenar un array con numeros aleatorios
 * @author Curso
 *
 */

public class Ejercicio9 {
	
	public static int [] llenarArrayAleatorio(int desde, int hasta, int tam){
        int[] numeros = new int[tam];
        Random rnd = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rnd.nextInt(hasta - desde + 1) + desde;
        }
        return numeros;
}

}
