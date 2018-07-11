package com.ipartek.formacion.ejercicios.basicos.iniciales;
/**
 * 
 * @author Curso
 *4. Programa java que declare cuatro variables enteras A, B, C y D y asígnale un valor acada una. A continuación realiza las instrucciones necesarias para que: B tome el valor de C, C tome el valor de A, A tome el valor de D, D tome el valor de B.
 */
public class Ejercicio4 {
	public static void main(String[] args) {
		int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        
        System.out.println("El valor de las variables al inicio son : [a :"+a+". b:"+b+". c:"+c+". d:"+d+"]" );
        
        b = c;
        c = a;
        a = d;
        d = b;
        
        System.out.println("El valor de las variables al final son : [a :"+a+". b:"+b+". c:"+c+". d:"+d+"]" );
	}
}
