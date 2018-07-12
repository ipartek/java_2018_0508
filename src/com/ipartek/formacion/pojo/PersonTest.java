package com.ipartek.formacion.pojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

	Person p = new Person();
	
	@Test
	void testPersonNombreApellidoSexo() {
		Person p2 = new Person("Elisabet", "Ribes", 'M');
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		assertTrue(Person.SEXO_MUJER == p2.getSexo());
		
		p2 = new Person("Elisabet", "Ribes", 'H');
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		assertTrue(Person.SEXO_HOMBRE == p2.getSexo());
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		
		p2 = new Person("Elisabet", "Ribes", 'I');
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		assertTrue(Person.SEXO_INDEFINIDO == p2.getSexo());
		
		p2 = new Person("Elisabet", "Ribes", 'm');
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		assertTrue(Person.SEXO_MUJER == p2.getSexo());
		
		p2 = new Person("Elisabet", "Ribes", 'h');
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		assertTrue(Person.SEXO_HOMBRE == p2.getSexo());
		
		p2 = new Person("Elisabet", "Ribes", 'i');
		assertTrue("Elisabet".equals(p2.getNombre()));
		assertTrue("Ribes".equals(p2.getApellido()));
		assertTrue(Person.SEXO_INDEFINIDO == p2.getSexo());
	
		p2 = new Person(null, null, 'O');
		assertTrue("".equals(p2.getNombre()));
		assertTrue("" == p2.getApellido());
		assertTrue(Person.SEXO_INDEFINIDO == p2.getSexo());
		
		p2 = new Person("", "", 'o');
		assertTrue("".equals(p2.getNombre()));
		assertTrue("".equals(p2.getApellido()));
		assertTrue(Person.SEXO_INDEFINIDO == p2.getSexo());
		
	}
	@Test
	void testSetSexo() {
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());
		p.setSexo('h');
		assertTrue(Person.SEXO_HOMBRE == p.getSexo());
		p.setSexo('m');
		assertTrue(Person.SEXO_MUJER == p.getSexo());
		p.setSexo('z');
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());
		p.setSexo('H');
		assertTrue(Person.SEXO_HOMBRE == p.getSexo());
		p.setSexo('M');
		assertTrue(Person.SEXO_MUJER == p.getSexo());
		p.setSexo('Z');
		assertTrue(Person.SEXO_INDEFINIDO == p.getSexo());
	}
	
	@Test
	void testSetNota() {
		assertEquals(Person.NOTA_MINIMA, p.getNota());
		p.setNota(0.0f);
		assertEquals(Person.NOTA_MINIMA, p.getNota());
		p.setNota(10f);
		assertEquals(Person.NOTA_MAXIMA, p.getNota());
		p.setNota(6.2f);
		assertTrue(p.getNota() > Person.NOTA_MINIMA && p.getNota() < Person.NOTA_MAXIMA);
		p.setNota(-2.2f);
		assertEquals(Person.NOTA_MINIMA, p.getNota());
		p.setNota(101.2f);
		assertEquals(Person.NOTA_MAXIMA, p.getNota());
	}
	
	@Test
	void testSetEdad() {
		assertEquals(Person.EDAD_MINIMA, p.getEdad());
		p.setEdad(0);
		assertEquals(Person.EDAD_MINIMA, p.getEdad());
		p.setEdad(100);
		assertEquals(Person.EDAD_MAXIMA, p.getEdad());
		p.setEdad(40);
		assertTrue(p.getEdad() > Person.EDAD_MINIMA && p.getEdad() < Person.EDAD_MAXIMA);
		p.setEdad(18);
		assertEquals(Person.EDAD_MINIMA, p.getEdad());
		p.setEdad(65);
		assertEquals(Person.EDAD_MAXIMA, p.getEdad());
	}

}
