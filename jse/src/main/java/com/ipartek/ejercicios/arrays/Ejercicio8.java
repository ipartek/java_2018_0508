package com.ipartek.ejercicios.arrays;

import java.util.Scanner;

/**
 * Leer nombre y sueldo de 20 empleados y mostrar el que más gana
 * @author Curso
 *
 */

public class Ejercicio8 {
	
	private static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		String empleados[]= new String[3];
        double sueldos[]= new double[3];

        //variables donde guardar el nombre y sueldo del empleado que más gana
        String nombreMayor;
        double mayorSueldo;

        int i= 0;

        //se lee el primer empleado
        System.out.println("Lectura de nombres y sueldos de empleados: ");
        System.out.print("Empleado " + (i + 1) + ": ");
        empleados[i]= sc.nextLine();
        System.out.print("Sueldo: ");
        sueldos[i]= sc.nextDouble();

        //se toma el primero como mayor
        mayorSueldo= sueldos[i];
        nombreMayor= empleados[i];

        //se leen el resto de empleados
        for (i= 1; i < empleados.length; i++) {
            sc.nextLine(); //limpiar el buffer
            System.out.print("Empleado " + (i + 1) + ": ");
            empleados[i] = sc.nextLine();
            System.out.print("Sueldo: ");
            sueldos[i] = sc.nextDouble();
            //se compara el sueldo leído con el mayor
            if (sueldos[i] > mayorSueldo) {
                mayorSueldo= sueldos[i];
                nombreMayor= empleados[i];
            }
        }

        //mostrar resultados
        System.out.println("Empleado con mayor sueldo: " + nombreMayor );
        System.out.println("Sueldo: " + mayorSueldo);

}
	
}
