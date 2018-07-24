package com.ipartek.formacion.uf2216;

/**
 * long id, String isbn, String titulo, String formatoPapel , int nPaginas
 */
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RevistasTest {
	static long MOCK_ID = 10;
	static String MOCK_TITULO = "Titulo prueba";
	static String MOCK_ISBN = "1234567890";
	static String MOCK_FORMATO_PAPEL = "Digital";
	static int nPagians = 0;
	Revistas test;

	@Test
	public void setTittleTest() {
		Revistas revtTEst = new Revistas();
		assertTrue(Revistas.TITTLE_MAX_LENGTH == 140);

	}

	@Test
	public void revistaIsbnTest() {

		String test = "1234567890";
		

	}

}
