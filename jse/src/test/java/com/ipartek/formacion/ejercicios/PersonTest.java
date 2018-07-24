package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ipartek.formacion.pojo.Person;

public class PersonTest {

	@Test

	public void testSetSexo() {
		Person p = new Person();
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());

		p.setSexo('H');
		assertTrue(Person.SEXO_HOMBRE == p.getSexo());

		p.setSexo('h');
		assertTrue(Person.SEXO_HOMBRE == p.getSexo());

		p.setSexo('M');
		assertTrue(Person.SEXO_MUJER == p.getSexo());

		p.setSexo('m');
		assertTrue(Person.SEXO_MUJER == p.getSexo());

		p.setSexo('I');
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());

		p.setSexo('I');
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

		p.setNota(112);
		assertEquals(Person.NOTA_MAXIMA, p.getNota(), 0);

	}

	@Test
	public void testEdad() {
		Person p = new Person();
		assertEquals(Person.EDAD_MINIMA, p.getEdad(), 0);

		p.setEdad(12);
		assertEquals(Person.EDAD_MINIMA, p.getEdad(), 0);

		p.setEdad(18);
		assertEquals(Person.EDAD_MINIMA, p.getEdad(), 0);

		p.setEdad(Person.EDAD_MAXIMA);
		assertEquals(Person.EDAD_MAXIMA, p.getEdad(), 0);

		p.setEdad(85);
		assertEquals(Person.EDAD_MAXIMA, p.getEdad(), 0);
	}

	@Test
	public void testCosntructorConParametros() {

		Person p = new Person("Asier", 'h');
		assertEquals("Asier", p.getNombre());
		assertEquals(Person.SEXO_HOMBRE, p.getSexo());

		p = new Person("Asier", 'o');
		assertEquals("Asier", p.getNombre());
		assertEquals(Person.SEXO_INDEFINIDO, p.getSexo());

		p = new Person(null, 'o');
		assertEquals("", p.getNombre());
		assertEquals(Person.SEXO_INDEFINIDO, p.getSexo());
	}
}
