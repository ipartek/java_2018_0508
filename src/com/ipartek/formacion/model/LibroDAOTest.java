package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Libro;

public class LibroDAOTest {

	static LibroDAO dao = null;

	static Libro mock1;
	static final int MOCK1_ID = 1;
	static final String MOCK1_TITULO = "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA";
	static final String MOCK1_AUTOR = "Nacho Carretero";
	static final String MOCK1_EDITORIAL = "Libros del K.O.";
	static final String MOCK1_ISBN = "9788416001460";
	static final int MOCK1_NUM_PAGINAS = 358;

	static Libro mock2;
	static final int MOCK2_ID = 2;
	static final String MOCK2_TITULO = "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA";
	static final String MOCK2_AUTOR = "V.V.A.A.";
	static final String MOCK2_EDITORIAL = "Libros del K.O.";
	static final String MOCK2_ISBN = "9788467575057";
	static final int MOCK2_NUM_PAGINAS = 344;

	static Libro mock3;
	static final int MOCK3_ID = 3;
	static final String MOCK3_TITULO = "MATEMÁTICAS TRIMESTRAL SAVIA-15";
	static final String MOCK3_AUTOR = "V.V.A.A.";
	static final String MOCK3_EDITORIAL = "Ediciones SM";
	static final String MOCK3_ISBN = "9788467575071";
	static final int MOCK3_NUM_PAGINAS = 288;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = LibroDAO.getInstance();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		dao = null; // Eliminamos la instancia
	}

	@Before
	public void setUp() throws Exception { // Se ejecuta antes de cada Test

		try {
			mock1 = new Libro(MOCK1_ID, MOCK1_TITULO, MOCK1_AUTOR, MOCK1_EDITORIAL, MOCK1_ISBN, MOCK1_NUM_PAGINAS,
					true);
			dao.insert(mock1);

			mock2 = new Libro(MOCK2_ID, MOCK2_TITULO, MOCK2_AUTOR, MOCK2_EDITORIAL, MOCK2_ISBN, MOCK2_NUM_PAGINAS,
					false);
			dao.insert(mock2);

			mock3 = new Libro(MOCK3_ID, MOCK3_TITULO, MOCK3_AUTOR, MOCK3_EDITORIAL, MOCK3_ISBN, MOCK3_NUM_PAGINAS,
					false);
			dao.insert(mock3);

		} catch (Exception e) {

			System.out.println("LO SENTIMOS. El ISBN no es correcto.");
		}
	}

	@After
	public void tearDown() throws Exception { // Se ejecuta después de cada Test

		dao.delete(MOCK1_ID); // Mock1 ID
		dao.delete(MOCK2_ID); // Mock2 ID
		dao.delete(MOCK3_ID); // Mock3 ID

		mock1 = null; // Eliminamos el objeto prueba de memoria
		mock2 = null; // Eliminamos el objeto prueba de memoria
		mock3 = null; // Eliminamos el objeto prueba de memoria

	}

	@Test
	public void testInsert() {

		try {
			dao.insert(new Libro(4, null, null, null, null, 0, false)); // Todos los datos incorrectos
			fail("Debería haber lanzado excepción.");

			assertFalse(dao.insert(new Libro(4, null, null, null, "123456789", 20, true))); // ISBN correcto, demás
																							// datos incorrectos

		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testUpdate() {

		assertFalse(dao.update(null)); // Update para null como primer caso

		Libro lModificarConID;

		try { // Update de video existente

			lModificarConID = new Libro(MOCK1_ID, MOCK2_TITULO, MOCK2_AUTOR, MOCK1_EDITORIAL, MOCK2_ISBN,
					MOCK2_NUM_PAGINAS, false);

			assertTrue(dao.update(lModificarConID));

			Libro lModificado = dao.getById(MOCK1_ID); // Recuperamos el libro modificado

			assertEquals(MOCK1_ID, lModificado.getId());
			assertEquals(MOCK2_TITULO, lModificado.getTitulo());
			assertEquals(MOCK2_AUTOR, lModificado.getAutor());
			assertEquals(MOCK2_EDITORIAL, lModificado.getEditorial());
			assertEquals(MOCK2_ISBN, lModificado.getIsbn());
			assertEquals(MOCK2_NUM_PAGINAS, lModificado.getNumPaginas());
			assertEquals(false, lModificado.isPrestado());

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		Libro lModificarSinID;
		try { // Update de video inexistente

			lModificarSinID = new Libro(1234, MOCK3_TITULO, MOCK3_AUTOR, MOCK3_EDITORIAL, MOCK3_ISBN, MOCK3_NUM_PAGINAS,
					false);
			assertFalse(dao.update(lModificarSinID));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test
	public void testDelete() {

		assertTrue(dao.delete(MOCK1_ID)); // Libro existente
		assertEquals(2, dao.getAll().size());
		assertTrue(dao.delete(MOCK2_ID)); // Libro existente
		assertEquals(1, dao.getAll().size());

		assertFalse(dao.delete(-1)); // Libro inexistente
	}

	@Test
	public void testGetById() {

		assertEquals(null, dao.getById(4));

		Libro l = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, l.getId());
		assertEquals(MOCK1_TITULO, l.getTitulo());
		assertEquals(MOCK1_AUTOR, l.getAutor());
		assertEquals(MOCK1_EDITORIAL, l.getEditorial());
		assertEquals(MOCK1_ISBN, l.getIsbn());
		assertEquals(MOCK1_NUM_PAGINAS, l.getNumPaginas());
		assertEquals(true, l.isPrestado());

	}

	@Test
	public void testGetAllPrestados() {

		assertEquals(1, dao.getAllPrestados(true).size());
		assertEquals(2, dao.getAllPrestados(false).size());
	}

	@Test
	public void testBusqueda() {

		assertNotNull(dao.busqueda(null)); // Caso null

		assertEquals(0, dao.busqueda("new").size()); // No existe la búsqueda

		assertEquals(1, dao.busqueda("Fariña").size()); // 1 coincidencia, minúsculas
		assertEquals(1, dao.busqueda("FARIÑA").size()); // 1 coincidencia, mayúsculas

		assertEquals(2, dao.busqueda("TRIMESTRAL").size()); // Varias coincidencias

	}

}
