package com.ipartek.formacion.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testComparar() {

		assertTrue("manolo".equalsIgnoreCase("Manolo"));
		assertFalse("manolo".equals("Manolo"));

	}

	@Test
	public void testPersonNombreSexo() {

		Person p = new Person("Manolo", 'h');
		assertEquals("Manolo", p.getNombre());
		assertEquals('h', p.getSexo());

		p = new Person("Manolo", 'o');
		assertEquals("Manolo", p.getNombre());
		assertEquals('i', p.getSexo());

		p = new Person(null, 'h');
		assertEquals("", p.getNombre());
		assertEquals('h', p.getSexo());

	}

	@Test
	public void testSetSexo() {

		Person p = new Person();
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());

		p.setSexo('h');
		assertTrue(Person.SEXO_HOMBRE == p.getSexo());

		p.setSexo('H');
		assertTrue(Person.SEXO_HOMBRE == p.getSexo());

		p.setSexo('m');
		assertTrue(Person.SEXO_MUJER == p.getSexo());

		p.setSexo('M');
		assertTrue(Person.SEXO_MUJER == p.getSexo());

		p.setSexo('i');
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());

		p.setSexo('I');
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());

		p.setSexo('z');
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());

	}

	@Test
	public void testSetNota() {

		Person p = new Person();
		assertEquals(Person.NOTA_MINIMA, p.getNota(), 0);

		p.setNota(-2);
		assertEquals(Person.NOTA_MINIMA, p.getNota(), 0);

		p.setNota(0);
		assertEquals(Person.NOTA_MINIMA, p.getNota(), 0);

		p.setNota(2);
		assertEquals(2, p.getNota(), 0);

		p.setNota(Person.NOTA_MAXIMA);
		assertEquals(Person.NOTA_MAXIMA, p.getNota(), 0);

		p.setNota(33);
		assertEquals(Person.NOTA_MAXIMA, p.getNota(), 0);

		// assertEquals( 0.999 , 1.0, 0.1 );

	}

}
