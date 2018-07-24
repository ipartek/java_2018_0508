package com.ipartek.formacion.herencia;

public interface Imprimible {
	
	 default void imprimir() {
		 
		 System.out.println("Documento imprimido");
		
		
	}

}
