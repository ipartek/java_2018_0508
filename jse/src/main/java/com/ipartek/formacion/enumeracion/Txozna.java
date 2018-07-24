package com.ipartek.formacion.enumeracion;

import java.io.IOException;
import java.util.Scanner;

public class Txozna {

	public static void main(String[] args) {

		char chBebida;
		char chRecipiente;
		
		Scanner sc = new Scanner(System.in);
		try {

			do {
				System.out.print("¿Que quieres tomar (k)alimotxo o (C)erveza?");
				chBebida = sc.nextLine().charAt(0);
				 
			} while (Character.toUpperCase(chBebida) != 'K' && Character.toUpperCase(chBebida) != 'C');

			do {
				System.out.print("¿(K)atxi o (V)aso?");
				chRecipiente = sc.nextLine().charAt(0);
				
			} while (Character.toUpperCase(chRecipiente) != 'K' && Character.toUpperCase(chRecipiente) != 'V');

			Bebida bebida = new Bebida(((Character.toUpperCase(chRecipiente) == 'K') ? Vaso.KATXI : Vaso.VASO),
					((Character.toUpperCase(chBebida) == 'K') ? PrecioBebida.KALIMOTXO : PrecioBebida.CERVEZA));

			System.out.println("Son " + bebida.calcularPrecio() + " euros");

			System.in.close();

		} catch (IOException e) {
			System.out.println("ERROR al introducir los datos");
			e.printStackTrace();

		} finally {
			sc.close();
			
		}

	}

}
