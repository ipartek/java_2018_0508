package com.ipartek.formacion.ejercicios.basicos.iniciales;
/**
 * 
 * @author Curso
 *Escribe un programa Java que declare una variable entera N y asígnale un valor. A continuación escribe las instrucciones que realicen los siguientes:<br>
Incrementar N en 77.<br>
Decrementarla en 3..<br>
Duplicar su valor..<br>
 */
public class Ejercicio3 {
	public static void main(String[] args) {
	int n = 6;
	System.out.println(n + " Valor inicial");
    n += 77;
    System.out.println(n + " Incrementado en  +77");
    n -=3;
    System.out.println(n + " Se le resta 3");
    n *=2;
    System.out.println(n  +" Multiplicado *2");
    System.out.println(n);
	}
}
