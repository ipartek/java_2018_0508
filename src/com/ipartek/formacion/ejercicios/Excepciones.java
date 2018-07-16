package com.ipartek.formacion.ejercicios;

import java.util.ArrayList;
import java.util.Iterator;

public class Excepciones {

	public static void main(String[] args) {

		System.out.println("Comenzamos ejecucion....");

		try {
			/*
			 * Object o = null; o.toString();
			 */

			// TODO capturar y conseguir que entre en un catch de ArrayIndexOfBoundException

			// TODO crear una nueva clase Excepciones2 con metodo main, metodoA y metodoB y
			// metodoC
			// l a llama al b, el b al c y el c produce la excepcion.

			// Declaración el ArrayList
			int[] array = new int[5];
			int exceptionArray = array[5];
		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.println("ArrayIndexOutOfBoundsException");

		} catch (NullPointerException e) {
			System.out.println("Null exception");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("USUARIO=> Upps,Lo sentimos pero ha surgido un problema");

			System.out.println("LOG=> " + e);
		} finally {
			System.out.println("terminamos ejecucion(Siempre se debe ejecutar)");

		}

	}

}
