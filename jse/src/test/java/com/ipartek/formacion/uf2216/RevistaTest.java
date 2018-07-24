package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RevistaTest {

	private static Revista revista2 = null;
	private static final String INIT_TITULO = "";
	private static final String INIT_ISBN = "";
	private static final int INIT_NUMPAGINAS = 0;
	private static final boolean INIT_FORMATO = false;

	@Test
	public void testRevista() throws Exception {

		Revista revista1 = new Revista();
		assertEquals(-1, revista1.getId());
		assertEquals(INIT_TITULO, revista1.getTitulo());
		assertEquals(INIT_ISBN, revista1.getIsbn());
		assertEquals(INIT_NUMPAGINAS, revista1.getNumeroPaginas());
		assertEquals(INIT_FORMATO, revista1.isFormato());

	}

	@Before
	public void setUp() throws Exception {
		revista2 = new Revista(1, "test", "1234567890", 10, false);
		assertEquals(1, revista2.getId());
		assertEquals("test", revista2.getTitulo());
		assertEquals("1234567890", revista2.getIsbn());
		assertEquals(10, revista2.getNumeroPaginas());
		assertEquals(false, revista2.isFormato());
	}

	@After
	public void tearDown() throws Exception {

	}

	public void testSetId() throws Exception {
		revista2.setId(3);
		assertEquals(3, revista2.getId());

	}

	@Test(expected = Exception.class)
	public void testSetTitulo() throws Exception {
		revista2.setTitulo("");
		revista2.setTitulo("21");
		revista2.setTitulo(null);

		revista2.setTitulo("  titulo correcto");
		assertEquals("titulo correcto", revista2.getTitulo());

	}

	@Test(expected = Exception.class)
	public void testSetIsbn() throws Exception {
		revista2.setIsbn("");
		revista2.setIsbn("21");
		revista2.setIsbn(null);

		revista2.setTitulo("1234567890");
		assertEquals("1234567890", revista2.getIsbn());
	}

	@Test(expected = Exception.class)
	public void testSetNumeroPaginas() throws Exception {
		revista2.setNumeroPaginas(-1);
		revista2.setNumeroPaginas(5);
		assertEquals("5", revista2.getIsbn());

	}

	@Test
	public void testSetFormato() {
		revista2.setFormato(true);
		assertEquals(true, revista2.isFormato());

	}

}
