package com.ipartek.formacion.enumeracion;

import java.util.Scanner;

public class Txozna {

	static Scanner scConsola = new Scanner(System.in);
	static Bebida pedido;
	static char c;

	public static void main(String[] args) {

		Bebida pedido = new Bebida();
		Vaso vaso;
		PrecioBebida precio;

		do { // Pedimos bebida

			System.out.println("¿ Que quieres tomar (K)alimotxo o (C)erveza ?");
			c = scConsola.nextLine().charAt(0);

		} while (!esOpcionValida(c, true));

		precio = creaPreciobebida(c);
		pedido.setPrecioBebida(precio); // Ponemos en pedido la bebida creada

		do { // Pedimos tamaño del vaso

			System.out.println("¿ (K)Katxi o (V)aso ?");
			c = scConsola.nextLine().charAt(0);

		} while (!esOpcionValida(c, false));

		vaso = creaVaso(c);
		pedido.setVaso(vaso); // Ponemos en pedido el vaso creado

		System.out.println("Son " + pedido.calcularPrecio() + " euros");

	} // FIN main();

	private static PrecioBebida creaPreciobebida(char c) {
		PrecioBebida precio = null;

		if (c == 'K' || c == 'k') {
			precio = PrecioBebida.KALIMOTXO;
		} else {
			precio = PrecioBebida.CERVEZA;
		}
		return precio;

	} // FIN creaPreciobebida();

	private static Vaso creaVaso(char c) {
		Vaso vaso = null;

		if (c == 'K' || c == 'k') {
			vaso = Vaso.KATXI;

		} else {
			vaso = Vaso.VASO;
		}
		return vaso;
	}

	private static boolean esOpcionValida(char c, boolean esBebida) {
		boolean res = false;

		if (esBebida) { // Para las bebidas
			if (c == 'C' || c == 'c' || c == 'K' || c == 'k') {
				res = true;
			}
		} else { // Para los tamaños
			if (c == 'V' || c == 'v' || c == 'K' || c == 'k') {
				res = true;
			}
		}
		return res;

	} // FIN esOpcionValida();

} // FIN Txozna
