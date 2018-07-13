package com.ipartek.formacion.ejercicios.bucles.anidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author drohne
 *2. Leer un número N y calcular el factorial de los números desde 0 hasta N.
 *ejemplo 4 = 4*3*2*1 -> 24
 */
public class Ejercicio2 {
	public static void main(String[] args) throws Exception {
		int n;
        double factorial;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        //Leer un número entero >= 0
        do{
            System.out.print("Introduce un número > 0: ");
            n = Integer.parseInt(br.readLine());
        }while(n<0);

        for(int i = 0; i <= n ; i++){ //para cada número desde 1 hasta N
           
            //se calcula su factorial
            factorial = 1;
            for(int j = 1; j <= i; j++){
                factorial = factorial * j;
            }

            //se muestra el factorial
            System.out.printf("%2d! = %.0f %n", i, factorial);

	}
}
}
