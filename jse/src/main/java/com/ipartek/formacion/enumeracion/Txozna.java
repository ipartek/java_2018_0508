package com.ipartek.formacion.enumeracion;

import java.util.Scanner;

public class Txozna {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		char opcionBebida;
		char opcionVaso;
		
		System.out.println("¿ Que quieres tomar (K)alimotxo o (C)erveza ?");
		opcionBebida = teclado.next().charAt(0);
		opcionBebida = Character.toUpperCase(opcionBebida);
		
		System.out.println();
		System.out.println("¿ (K)Katxi o (V)aso ?");
		opcionVaso = teclado.next().charAt(0);
		opcionVaso = Character.toUpperCase(opcionVaso);
		
		System.out.println("Son X euros");
		
		teclado.close();
	}

}
