package com.ipartek.formacion.ejercicios.basicos.estructura.condicional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * @author Curso1 10. Programa que lea una variable entera mes y compruebe si el
 *         valor corresponde a un mes de 30, 31 o 28 días. Se mostrará además el
 *         nombre del mes. Se debe comprobar que el valor introducido esté
 *         comprendido entre 1 y 12. 30-28-31-30-31-30-31-30-31-30-31-30
 *
 */

public class Ejercicio10 {
	private static int[] mesesDias = { 24, 60, 60 };

	public static void main(String[] args) throws Exception {
		int mesUsuario ;
		String nombreMes;
		int diasMes = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce un mes  :");
		mesUsuario = Integer.parseInt(br.readLine());
        switch (mesUsuario) {
    		case 1: 
    			nombreMes = "Enero";
    			diasMes = 31;
                break;
            case 2:  
            	nombreMes = "Febrero";
            	diasMes = 28;
                break;
            case 3:  
            	nombreMes = "Marzo";
            	diasMes = 31;
                break;
            case 4:
            	nombreMes = "Abril";
            	diasMes = 30;
                break;
            case 5:
            	nombreMes = "Mayo";
            	diasMes = 31;
                break;
            case 6:
            	nombreMes = "Junio";
            	diasMes = 30;
                break;
            case 7:
            	nombreMes = "Julio";
            	diasMes = 31;
                break;
            case 8:
            	nombreMes = "Agosto";
            	diasMes = 31;
                break;
            case 9:
            	nombreMes = "Septiembre";
            	diasMes = 30;
                break;
            case 10:
            	nombreMes = "Octubre";
            	diasMes = 31;
                break;
            case 11:
            	nombreMes = "Noviembre";
            	diasMes = 30;
                break;
            case 12:
            	nombreMes = "Diciembre";
            	diasMes = 31;
                break;
            default: 
            	nombreMes = "Invalid month";
            	mesUsuario = 0;
                break;
        }
        System.out.println(nombreMes+" tiene: "+diasMes+" dias");
    }
}


