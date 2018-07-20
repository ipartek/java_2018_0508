package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class RevistasTest {

	static Revistas mock1;
	static Revistas mock2;

	private static final long MOCK1_ID = 1;
	private static final String MOCK1_TITULO = "Superlopez";
	private static final String MOCK1_ISBN = "5up3rl0p3z";
	private static final int MOCK1_NUM_PAG = 5303;
	private static final boolean MOCK1_ES_DIGITAL = true;

	@Test
	public void testGetId() throws Exception {

		final Revistas pojo = new Revistas();

		pojo.setId(MOCK1_ID);

		assertEquals(MOCK1_ID, pojo.getId());

	}

	@Test
	public void testGetTitulo() throws Exception {

		final Revistas pojo = new Revistas();

		pojo.setTitulo(MOCK1_TITULO);

		assertEquals("Superlopez", MOCK1_TITULO);

	}

	@Test
	public void testGetIsbn() throws Exception {

		final Revistas pojo = new Revistas();

		pojo.setIsbn(MOCK1_ISBN);

		assertEquals(MOCK1_ISBN, pojo.getIsbn());

	}

	@Test
	public void testIsDigital() {

		final Revistas pojo = new Revistas();
		assertFalse(pojo.isDigital());

	}

	@Test
	public void testToString() throws Exception {

		Revistas rev = new Revistas(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUM_PAG, MOCK1_ES_DIGITAL);
		assertEquals("Revistas [id=1, titulo=Superlopez, isbn=5up3rl0p3z, numPaginas=5303, digital=true]",
				rev.toString());
	}

}
