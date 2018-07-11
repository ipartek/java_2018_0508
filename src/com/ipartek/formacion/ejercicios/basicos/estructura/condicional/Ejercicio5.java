package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		char letra1, letra2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una letra");
		letra1 = sc.next().charAt(0);
		
		System.out.println("Introduce otra letra");
		letra2 = sc.next().charAt(0);
		
		if(letra1>='a' && letra1<='z'){
            if(letra2>='a' && letra2<='z')
               System.out.println("Los dos son letras minúsculas");
           else {
        	   System.out.println("Una es minuscula pero la otra no");
           }           
        }
		sc.close();
	}

}
