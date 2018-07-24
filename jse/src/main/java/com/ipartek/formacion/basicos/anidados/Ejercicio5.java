package com.ipartek.formacion.basicos.anidados;

/**
 * Programa Java que muestre todos los valores de un contador de 5 dígitos
 * empezando por 00000 y acabando en 99999 con la particularidad que cada vez
 * que se deba mostrar un 3 se muestre E.
 * 
 * @author Curso
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				for (int k=0; k<10; k++) {
					for (int l=0; l<10; l++) {
						for (int m=0; m<10; m++) {
							
							System.out.print(i != 3 ? i : "E");
                            System.out.print(j != 3 ? j : "E");
                            System.out.print(k != 3 ? k : "E");
                            System.out.print(l != 3 ? l : "E");
                            System.out.println(m != 3 ? m : "E");
                            
						}
					}
				}
			}
		}
	}

}
