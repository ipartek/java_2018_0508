package com.ipartek.formacion.enumeracion;

import java.util.Scanner;

public class Txozna {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		PrecioBebida liquido = null;
		Vaso recipiente = null;
		String texto = "";
		boolean avanzar = false;
		Bebida drink = new Bebida();

		do {

			System.out.println("� Que quieres tomar (K)alimotxo o (C)erveza ?");
			texto = sc.next();

			if ("K".equalsIgnoreCase(texto)) {
				drink.setPrecioBebida(liquido.KALIMOTXO);
				avanzar = true;
			} else if ("C".equalsIgnoreCase(texto)) {
				drink.setPrecioBebida(liquido.CERVEZA);
				avanzar = true;
			} else {
				System.out.println("Lo siento pero solo me queda Kalimotxo o cerveza");
				avanzar = false;
			}

		} while (avanzar == false/* !"K".equalsIgnoreCase(texto) || "C".equalsIgnoreCase(texto) */);

		do {
			sc.nextLine();
			System.out.println("� (K)Katxi o (V)aso ?");
			texto = sc.next();

			if ("K".equalsIgnoreCase(texto)) {
				drink.setVaso(recipiente.KATXI);
				avanzar = true;
			} else if ("V".equalsIgnoreCase(texto)) {
				drink.setVaso(recipiente.VASO);
				avanzar = true;
			} else {
				System.out.println("Lo siento pero solo tienes de opcion vaso o katxi");
				avanzar = false;
			}

		} while (avanzar == false/* !"K".equalsIgnoreCase(texto) || !"V".equalsIgnoreCase(texto) */);

		float total = drink.calcularPrecio();

		System.out.println("Son " + total + "€ el total");

		sc.close();
	}

}
