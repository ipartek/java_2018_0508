package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuscarEnDirectorio {

	static File[] unidades;
	static String[] archivos;

	static final String BUSQUEDA = "tesoro";

	public static void main(String[] args) {

		File f = new File("ficheros");
		recorre(f);
	}

	public static void recorre(File dir) {

		File listFile[] = dir.listFiles();

		if (listFile != null) {
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isDirectory()) {
					recorre(listFile[i]);
				} else {
					if (buscarEnFichero(listFile[i], BUSQUEDA)) {
						System.out.println(listFile[i].getPath());
					}
				}
			}
		}
	}

	private static boolean buscarEnFichero(File f, String busca) {

		boolean result = false;

		try {

			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String linea = null;

			try {

				while ((linea = br.readLine()) != null) {
					if (linea.contains(busca)) {
						result = true;
						break;
					}
				}
			} finally {
				if (fr != null) {
					fr.close();
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		return result;

	}

}
