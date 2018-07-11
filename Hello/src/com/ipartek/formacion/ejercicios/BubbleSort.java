package com.ipartek.formacion.ejercicios;

import java.util.logging.Logger;

public class BubbleSort {

	public static void main(String[] args) {
		Logger log = Logger.getLogger(BubbleSort.class.getName());
		Integer[] num = new Integer[10];
		num = new Integer[] { 0,3,1,8,7,2,5,4,6,9};
		int aux;
		log.info(" Array desordenado: ");
		log.info("------------------- ");
		for (int i = 0; i < num.length - 1; i++) {
	        log.info(" " + num[i]);
	    }
		log.info(" Array ordenado de menor a mayor: ");
		log.info("------------------- ");
	    for (int i = 0; i < num.length - 1; i++) {
	        for (int x = i + 1; x < num.length; x++) {
	            if (num[x] < num[i]) {
	                aux = num[i];
	                num[i] = num[x];
	                num[x] = aux;
	            }
	        }
	        log.info(i + " " + num[i]);
	    }
	    log.info(" Array ordenado de mayor a menor: ");
		log.info("------------------- ");
	    for (int i = 0; i < num.length - 1; i++) {
	        for (int x = i + 1; x < num.length; x++) {
	            if (num[x] > num[i]) {
	                aux = num[i];
	                num[i] = num[x];
	                num[x] = aux;
	            }
	        }
	        log.info(i + " " + num[i]);
	    }
	
	}
		
}

