package com.ipartek.formacion.ejercicios.generales;

import java.io.IOException;
import java.util.Scanner;

/**
 * Programa para codificar o decodificar un texto utilizando el método de cifrado de César
 * @author Curso
 *
 */
public class Ejercicio12 {

	public static void main(String[] args) throws IOException {
		
		Scanner teclado = new Scanner(System.in);
		
        String texto;
        int codigo;
        char opcion;
        
        //Introducir texto a cifrar o descifrar
        do {
            System.out.print("Introduce un texto: ");
            texto = teclado.nextLine();
        } while (texto.isEmpty());
        
        //Introducir codigo para el cifrado
        do {
            System.out.print("Introduce el código: ");
            codigo = teclado.nextInt();
        } while (codigo < 1);
        
        //Decidir si cifrar o descifrar
        do {
            teclado.nextLine();
            System.out.print("(C) cifrar o (D) descifrar?: ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));
        } else {
            System.out.println("Texto descifrado: " + descifradoCesar(texto, codigo));
        }
        
        teclado.close();
	}

	/**
	 * Metodo para descifrar un texto
	 * @param texto
	 * @param codigo
	 * @return
	 */
	private static String descifradoCesar(String texto, int codigo) {
		StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (texto.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
	}
	
	/**
	 * Metodo para cifrar un texto
	 * @param texto
	 * @param codigo
	 * @return
	 */
	private static String cifradoCesar(String texto, int codigo) {
		StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
	}

}
