package com.ipartek.formacion.enumeracion;

import java.util.Scanner;

public class Txozna {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Bebida b = new Bebida();

		char c = ' ';

		try {

			System.out.println("¿ Que quieres tomar (K)alimotxo o (C)erveza ?");
			c = sc.nextLine().toUpperCase().charAt(0);

			switch (c) {
			case 'K':
				b.setPrecioBebida(PrecioBebida.KALIMOTXO);
				break;

			default:
				b.setPrecioBebida(PrecioBebida.KALIMOTXO);
				break;
			}

			c = ' ';

			System.out.println("¿ (K)Katxi o (V)aso ?");
			c = sc.nextLine().toUpperCase().charAt(0);

			switch (c) {
			case 'K':
				b.setVaso(Vaso.KATXI);
				break;

			default:
				b.setVaso(Vaso.VASO);
				break;
			}
			
			System.out.println("Son "+b.calcularPrecio()+" euros");

		} catch (Exception e) {

			System.out.println("Hemos tenido un problema tecnico, disculpe las molestias.");

		} finally {
			
			sc.close();
			
		}

	}

}
