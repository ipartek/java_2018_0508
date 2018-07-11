package com.ipartek.formacion.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testSetSexo() {
		Person p = new Person();
		
		assertTrue(Person.SEX_INDEFINIDO == p.getSexo());
		p.setSexo('h');
		assertTrue(Person.SEX_HOMBRE == p.getSexo());
		p.setSexo('H');
		assertTrue(Person.SEX_HOMBRE == p.getSexo());
		p.setSexo('m');
		assertTrue(Person.SEX_MUJER== p.getSexo());
		p.setSexo('M');
		assertTrue(Person.SEX_MUJER== p.getSexo());
		p.setSexo('i');
		assertTrue(Person.SEX_INDEFINIDO == p.getSexo());
		p.setSexo('I');
		assertTrue(Person.SEX_INDEFINIDO == p.getSexo());
		p.setSexo('z');
		assertTrue(Person.SEX_INDEFINIDO == p.getSexo());
		
	}
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
		
	}
	public void testSetEdad() {
		Person p = new Person();
		
		p.setEdad(18);
		assertEquals(Person.EDAD_MINIMA, p.getNota(), 0);
		p.setEdad(65);
		assertEquals(Person.EDAD_MAXIMA, p.getNota(), 0);
		
		
	}
	
	public void testPersonNombreSexo() {
		Person p = new Person("Manolo",'h');
		assertEquals("Manolo",p.getNombre());
		assertEquals('h',p.getSexo());
		
		p = new Person("Manolo",'o');
		assertEquals("Manolo",p.getNombre());
		assertEquals('i',p.getSexo());
		
		p = new Person(null,'h');
		assertEquals("",p.getNombre());
		assertEquals('h',p.getSexo());
		
	}

}
