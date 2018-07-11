package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;
import java.util.Scanner;

/**
 * El programa lee por teclado tres números enteros y calcula y muestra el mayor
 * de los tres.
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);		
		float[]nums = new float[3];
		float max = 0;
		for (int i = 0; i < nums.length; i++) {
			System.out.print("Introduzca un numero: ");
			nums[i]=teclado.nextFloat();
			if(nums[i]>max) {
				max=nums[i];
			}
		}
		System.out.print("De los numeros ");
		for (float num : nums) {
			System.out.print(" "+num+" ");
		}
		System.out.println(" el mayor es: "+max);
		teclado.close();

	}

}
