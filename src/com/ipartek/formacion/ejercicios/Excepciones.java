package com.ipartek.formacion.ejercicios;

public class Excepciones {

	public static void main(String[] args) {
		
		
		System.out.println("Comenzamos ejecución.....");
		
		try {
		/*	Object o = null;
			o.toString(); */
			
			//TODO capturar y conseguir que entre en un catch de ArrayIndexOfBoundException
			Integer[] arrayExample = new Integer[5];
			arrayExample[6] = 9;
			
			//TODO crear una nueva clase Excepciones2 con un metodo main, metodoA, metodoB, metodoC
			//main llama al A , A llama al B, B llama al C, C lanza excepcion nullPointer
			
		}
		catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Ha saltado la expception ArrayIndexOfBoundException");
			System.out.println("LOG => " + e.getMessage() + "---" +  e.getCause());
		}
		/*catch(Exception e) {
			System.out.println("USER => Ha saltado una excepcion nullPointer");
			
			System.out.println("LOG => " + e.getMessage() + " --- " + e.getCause());
		}*/
		finally {
			System.out.println("Terminamos ejecución");
		}
		
		
		

	}

}
