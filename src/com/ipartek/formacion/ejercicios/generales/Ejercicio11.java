package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso 11. Convertir a Números Romanos
 */
public class Ejercicio11 {
	public static void main(String[] args) throws Exception {
		
		int u, d, c, m, numero;
		
		System.out.println("Introduce una cifra en numeros romanos");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numero = Integer.parseInt(br.readLine());
		m = numero / 1000;
		c = (numero % 1000) / 100;
		d = ((numero % 1000) % 100) / 10;
		u = (((numero % 1000) % 100) % 10);
		System.out.println(m);
		System.out.println(c);
		System.out.println(d);
		System.out.println(u);
	}
}
