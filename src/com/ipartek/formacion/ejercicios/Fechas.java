package com.ipartek.formacion.ejercicios;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fechas {

	public static void main(String[] args) {
		
		Calendar c1 = GregorianCalendar.getInstance();

        System.out.println("Fecha actual: "+c1.getTime());
        
        Date d = new Date();
        System.out.println("Fecha actual: "+d.toString());

	}

}
