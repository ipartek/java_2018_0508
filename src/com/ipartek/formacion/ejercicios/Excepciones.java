package com.ipartek.formacion.ejercicios;

public class Excepciones {
	
	public static void main(String[] args) {
		System.out.println("Comenzamos ejecucion....");
				
		//TODO capturar excepcion y que el terminar excepcion siempre se ejecute
		try {
			/*Object o = null;
			o.toString();*/
			
			int [] prueba = {1,2};
			System.out.println(prueba[2]);
			
			
		//Captura de excepcion mas fina y concreta
		}/*catch (NullPointerException e) {
				// TODO: handle exception
			System.out.println("NULL exception");
			
		}*/
		
		//TODO conseguir que entre en un catch array index out of bounds exception
		
		catch(ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println("Error. Nos hemos salido del array.");
		}
		
		catch(Exception e) {
			//e.printStackTrace();
			//Mensaje para usuario
			System.out.println("UPSS. Lo sentimos pero ha surgido un error.");
			
			//Mensaje para un log
			//System.out.println("LOG=> "+ e.getMessage() + " " + e.getCause());
			System.out.println(e);
		}finally {
			System.out.println("Terminamos ejecucion");
		}		
	}
}
