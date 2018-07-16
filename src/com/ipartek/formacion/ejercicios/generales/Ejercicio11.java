package com.ipartek.formacion.ejercicios.generales;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ipartek.formacion.pojo.RomanNumber;

/**
 * Convertir a Números Romanos
 */
public class Ejercicio11 {

	public static void main(String[] args) {

		System.out.print("Introduce un numero del 1 al 999: ");
		Scanner teclado = new Scanner(System.in);
		int num = teclado.nextInt();

		List<RomanNumber> list = new ArrayList<RomanNumber>();
		list.add(new RomanNumber('M', 1000));// dos
		list.add(new RomanNumber('D', 500));// ant
		list.add(new RomanNumber('C', 100));// dos
		list.add(new RomanNumber('L', 50));// ant
		list.add(new RomanNumber('X', 10));// dos
		list.add(new RomanNumber('V', 5)); // ant
		list.add(new RomanNumber('I', 1));

		String str = "";

		int j = 0;

		for (RomanNumber romanNumber : list) {

			if (num <= 0) {
				break;
			}

			if (num / romanNumber.getCode() > 0) {
				for (int i = 0; i < num / romanNumber.getCode(); i++) {
					str += romanNumber.getWord();
				}
				num %= romanNumber.getCode();
			}

			if (j+1 < list.size()) {
				if (num / (romanNumber.getCode() - list.get(j + ((j % 2 == 0) ? 2 : 1)).getCode()) > 0) {
					str += list.get(j + ((j % 2 == 0) ? 2 : 1)).getWord()+""+ romanNumber.getWord();
					num %= romanNumber.getCode() - list.get(j + ((j % 2 == 0) ? 2 : 1)).getCode();

				}
			}

			j++;
		}
		System.out.println("El numero romano es: " + str);
		teclado.close();

	}

}
