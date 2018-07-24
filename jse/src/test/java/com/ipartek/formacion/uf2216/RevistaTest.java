package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RevistaTest {

	Revista mock1DigitalCorrecto; // Un mock es un objeto de prueba
	private static final long MOCK1_ID = 1;
	private static final String MOCK1_TITULO = "Las aventuras de Tom Sawyer";
	private static final String MOCK1_ISBN = "1000000000";
	private static final int MOCK1_NUM_PAGS = 120;
	private static final boolean MOCK1_ES_DIGITAL = true;

	Revista mock2PapelCorrecto; // Un mock es un objeto de prueba
	private static final long MOCK2_ID = 2;
	private static final String MOCK2_TITULO = "Oliver Twist";
	private static final String MOCK2_ISBN = "1000000020";
	private static final int MOCK2_NUM_PAGS = 220;
	private static final boolean MOCK2_ES_DIGITAL = false;

	@Before
	public void setUp() throws Exception {

		mock1DigitalCorrecto = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUM_PAGS, MOCK1_ES_DIGITAL);
		mock2PapelCorrecto = new Revista(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUM_PAGS, MOCK2_ES_DIGITAL);

		// Pruebas incorrectas
		try {

			Revista revTituloIncorrecto = new Revista(3, "as", MOCK1_ISBN, MOCK1_NUM_PAGS, MOCK1_ES_DIGITAL);
			assertNull(revTituloIncorrecto);

		} catch (RevistaException e) {
			assertTrue("Título incorrecto", true);
		}

		try {

			Revista revISBNIncorrecto = new Revista(4, MOCK1_TITULO, "100", MOCK1_NUM_PAGS, MOCK1_ES_DIGITAL);
			assertNull(revISBNIncorrecto);

		} catch (RevistaException e) {

			assertTrue("ISBN incorrecto", true);

		}

		try {

			Revista revPagsIncorrectas = new Revista(5, MOCK1_TITULO, MOCK1_ISBN, 0, MOCK1_ES_DIGITAL);
			assertNull(revPagsIncorrectas);

		} catch (RevistaException e) {

			assertTrue("Num. Páginas incorrectas", true);

		}
	}

	@After
	public void tearDown() throws Exception {

		mock1DigitalCorrecto = null;
		mock2PapelCorrecto = null;
	}

	@Test
	public void testRevista() {

		// Pruebas para el mock1 (Digital == True)

		assertEquals(MOCK1_TITULO, mock1DigitalCorrecto.getTitulo());
		assertEquals(MOCK1_ISBN, mock1DigitalCorrecto.getIsbn());
		assertEquals(MOCK1_NUM_PAGS, mock1DigitalCorrecto.getNumPaginas());
		assertTrue(mock1DigitalCorrecto.isFormato());

		// Pruebas para el mock2 (Digital == False)

		assertEquals(MOCK2_TITULO, mock2PapelCorrecto.getTitulo());
		assertEquals(MOCK2_ISBN, mock2PapelCorrecto.getIsbn());
		assertEquals(MOCK2_NUM_PAGS, mock2PapelCorrecto.getNumPaginas());
		assertFalse(mock2PapelCorrecto.isFormato());

	}

}
