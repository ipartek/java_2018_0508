package com.ipartek.formacion.ejercicios;

public class Excepciones {
	
	public static void main(String[] args) {
		System.out.println("Comenzamos ejecucion....");
		try {

			int [] prueba = {1,2};
			System.out.println(prueba[2]);
			
			
		//Captura de excepcion mas fina y concreta
		}/*catch (NullPointerException e) {
			System.out.println("NULL exception");
			
		}*/
		
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error. Nos hemos salido del array.");
		}
		
		catch(Exception e) {
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
