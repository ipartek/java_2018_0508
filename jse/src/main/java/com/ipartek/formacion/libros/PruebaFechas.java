package com.ipartek.formacion.libros;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class PruebaFechas {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
		System.out.println(date.toString());
		String dateFormat = DateFormat.getInstance().format(date);
		System.out.println(dateFormat);
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
	}

}
