package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.Test;

public class RevistaTest {

	@Test
	public void testSetPaginas() {
		
		Revista revista = new Revista();
		assertNotNull(revista.getnPaginas());
		
		assertEquals(Revista.PAGINAS_MIN_LENGTH, revista.getnPaginas());
		
		revista.setnPaginas(-4);
		assertNotEquals(-4, revista.getnPaginas());
		assertEquals(Revista.PAGINAS_MIN_LENGTH, revista.getnPaginas());
		
		revista.setnPaginas(10);
		assertEquals(10, revista.getnPaginas());		
		
	}
	
	@Test
	public void testSetIsbn() {
		
		Revista revista = new Revista();
		assertNotNull(revista.getIsbn());
		
		try {
			revista.setIsbn("1234567890");
			assertEquals("1234567890", revista.getIsbn());
			
			revista.setIsbn("123");
			assertFalse(revista.getIsbn().length() == Revista.ISBN_LENGTH);
			
		} catch (Exception e) {
			System.out.println(Revista.ISBN_MENSAJE_EXCEPTION);
		}
		
		
	}
	
	@Test
	public void testSetTitulo() {
		
		Revista revista = new Revista();
		assertNotNull(revista.getTitulo());
		
		try {
			revista.setTitulo("NatGeo");
			assertEquals("NatGeo", revista.getTitulo());
			
			revista.setTitulo("El");
			assertFalse(revista.getTitulo().length() >= Revista.TITULO_MIN_LENGTH);
			
			revista.setTitulo("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris sed orci eu nunc condimentum scelerisque. Etiam bibendum placerat libero ac lobortis. Suspendisse augue mi, elementum et ante at, cursus interdum mauris. Proin congue, nunc in commodo porttitor, ex lorem pulvinar quam, ac maximus ex quam eget libero. Vivamus sagittis purus a luctus imperdiet. Vestibulum imperdiet elementum diam, id condimentum sapien luctus vitae. Nunc elementum neque et arcu malesuada, ac dapibus ante viverra. Sed nec lorem sed mi faucibus porttitor. Nullam mattis ac nulla nec condimentum.");
			assertFalse(revista.getTitulo().length() <= Revista.TITULO_MAX_LENGTH);
			
		} catch (Exception e) {
			System.out.println(Revista.TITULO_MENSAJE_EXCEPTION);
		}		
		
	}

}
