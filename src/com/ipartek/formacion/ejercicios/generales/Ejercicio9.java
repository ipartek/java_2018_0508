package com.ipartek.formacion.ejercicios.generales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ipartek.formacion.pojo.videoYoutube;

/**
 * 
 * @author Curso 9. Pasar de decimal a binario
 *c
 */
public class Ejercicio9 {

	public static void main(String[] args) throws Exception {
		int numero, exp, digito;
        double binario;
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do{ 
            System.out.print("Introduce un numero entero >= 0: ");
            numero = Integer.parseInt(br.readLine());
        }while(numero<0);

        exp=0;
        binario=0;
        while(numero!=0){
                digito = numero % 2;           
                binario = binario + digito * Math.pow(10, exp);  
                exp++;
                numero = numero/2;
        }
        System.out.printf("Binario: %.0f %n", binario);
	}
}
