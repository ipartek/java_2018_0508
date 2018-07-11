package com.ipartek.formacion.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

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
		
		p.setNota(19);
		assertEquals(Person.NOTA_MAXIMA, p.getNota(), 0);
		
		p.setNota(7.3f);
		assertEquals(7.3f, p.getNota(), 0);
		
		p.setNota(0);
		assertEquals(Person.NOTA_MINIMA, p.getNota(), 0);
		
		p.setNota(10);
		assertEquals(Person.NOTA_MAXIMA, p.getNota(), 0);
		
	}
	
	@Test
	public void testSetEdad() {
		Person p = new Person();
		assertTrue(Person.EDAD_MINIMA == p.getEdad());
		
		p.setEdad(3);
		assertTrue(Person.EDAD_MINIMA == p.getEdad());
		
		p.setEdad(18);
		assertTrue(Person.EDAD_MINIMA == p.getEdad());
		
		p.setEdad(35);
		assertTrue(35 == p.getEdad());
		
		p.setEdad(65);
		assertTrue(Person.EDAD_MAXIMA == p.getEdad());
		
		p.setEdad(88);
		assertTrue(Person.EDAD_MAXIMA == p.getEdad());
	}
	
	@Test
	public void testPersonNombreSexo() {
		
		Person a = new Person("Carlos", 'o');
		assertEquals("Carlos", a.getNombre());
		assertEquals('i', a.getSexo());
		
		Person b = new Person("Carlos", 'h');	
		assertEquals("Carlos", b.getNombre());
		assertTrue(Person.SEXO_HOMBRE == b.getSexo());
		
		Person c = new Person(null, 'o');	
		assertEquals("", c.getNombre());
		assertTrue(Person.SEXO_INDEFINIDO == c.getSexo());
		
	}

}
