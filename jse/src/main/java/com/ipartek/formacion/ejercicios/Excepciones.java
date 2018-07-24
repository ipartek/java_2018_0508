package com.ipartek.formacion.ejercicios;


public class Excepciones {

	public static void main(String[] args) {
		System.out.println("Comenzamos ejecucion");

		// Scanner sc = new Scanner(System.in);
		Object o = null;
		try {
			o.toString();
			
		}catch (NullPointerException e) {
			System.out.println("NULL");
		
		} catch (Exception e) {
			System.out.println("Lo sentimos pero a surgido un problema");
			
			System.out.println("Mensaje: "+e.getMessage());
					
			System.out.println("Causa: "+e.getCause());			
			
		} finally {
			System.out.println("Terminamos ejecucion");
		}
		
		
		//TODO capturar y conseguir que entre en un cath de arrayIndexOfboundException
		int [] test = new int[2];
		try {
			int num =test[4];
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Crear una clase excepciones2 con un metodo main, metodoA, metodoB y metodo C
		//el main llama al A-> el B llama a C y el C casca y manda una excepcion
		
	}

}
