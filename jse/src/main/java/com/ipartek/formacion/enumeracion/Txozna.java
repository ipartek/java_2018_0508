package com.ipartek.formacion.enumeracion;

import java.util.Scanner;

public class Txozna {

	public static void main(String[] args) {

		String opcion1;
		String opcion2;
		float precioTotal = 0;
		boolean hayPrecio = false;
		boolean hayVaso = false;

		Scanner sc = new Scanner(System.in);

		Bebida b = new Bebida();

		do {
			System.out.println("¿Que quieres tomar (K)alimotxo o (C)erveza ?");
			opcion1 = sc.nextLine();
			
			if (opcion1.equalsIgnoreCase("K")) {
				b.setPrecioBebida(PrecioBebida.KALIMOTXO);
				hayPrecio = true;
			}				
			else if (opcion1.equalsIgnoreCase("C")) {
				b.setPrecioBebida(PrecioBebida.CERVEZA);
				hayPrecio = true;
			}				
			else {
				System.out.println("No se ha introducido una bebida valida.");
			}
		} while (/*!opcion1.equalsIgnoreCase("K") || !opcion1.equalsIgnoreCase("C")*/ !hayPrecio);

		do {
			System.out.println("¿(K)Katxi o (V)aso ?");
			opcion2 = sc.nextLine();

			if (opcion2.equalsIgnoreCase("K")) {
				b.setVaso(Vaso.KATXI);
				hayVaso = true;
				precioTotal = b.calcularPrecio(b.getPrecioBebida(), b.getVaso());
				System.out.println("Son " + precioTotal + " euros");
			}				
			else if (opcion2.equalsIgnoreCase("V")) {
				b.setVaso(Vaso.VASO);
				hayVaso = true;
				precioTotal = b.calcularPrecio(b.getPrecioBebida(), b.getVaso());
				System.out.println("Son " + precioTotal + " euros");
			}				
			else {
				System.out.println("No se ha introducido un vaso valido.");
			}				
		} while (/*!opcion2.equalsIgnoreCase("K") || !opcion2.equalsIgnoreCase("V")*/!hayVaso);
		
		sc.close();

	}

}
