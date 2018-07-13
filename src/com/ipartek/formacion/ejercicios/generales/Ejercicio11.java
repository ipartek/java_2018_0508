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
		list.add(new RomanNumber('M',1000));
		list.add(new RomanNumber('D',500));
		list.add(new RomanNumber('C',100));
		list.add(new RomanNumber('L',50));
		list.add(new RomanNumber('X',10));
		list.add(new RomanNumber('V',5));
		list.add(new RomanNumber('I',1));
		
		String str="";
		for (RomanNumber romanNumber : list) {
			if(num<=0) {
				break;
			}
			if(num/romanNumber.getCode() >0) {
				for (int i = 0; i <num/romanNumber.getCode(); i++) {
					str+=romanNumber.getWord();
				}
				num%=romanNumber.getCode();
			}
		}
		System.out.println("El numero romano es: "+str);
		teclado.close();


	}
	
	

}
