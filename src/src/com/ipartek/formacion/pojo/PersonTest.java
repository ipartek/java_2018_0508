package com.ipartek.formacion.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testSetGender() {
		Person p =new Person();
		assertEquals(Person.SEXO_INDEFINIDO,p.getGender());
		
		p.setGender('h');
		assertEquals(Person.SEXO_HOMBRE, p.getGender());
		
		p.setGender('m');
		assertEquals(Person.SEXO_MUJER, p.getGender());
		
		p.setGender('i');
		assertEquals(Person.SEXO_INDEFINIDO, p.getGender());
		
		p.setGender('H');
		assertEquals(Person.SEXO_HOMBRE, p.getGender());
		
		p.setGender('M');
		assertEquals(Person.SEXO_MUJER, p.getGender());
		
		p.setGender('I');
		assertEquals(Person.SEXO_INDEFINIDO, p.getGender());
		
		p.setGender('g');
		assertEquals(Person.SEXO_INDEFINIDO, p.getGender());
		
		p.setGender(' ');
		assertEquals(Person.SEXO_INDEFINIDO, p.getGender());
				
	}
	
	@Test
	public void testSetMark() {
		Person p =new Person();
		assertTrue(Person.NOTA_MIN == p.getMark());
		assertEquals(Person.NOTA_MIN,p.getMark(),0); // el 0 es la desviacion que quiero dejarle 
		
		p.setMark(15);
		assertTrue(Person.NOTA_MAX == p.getMark());
		
		p.setMark(-1);
		assertTrue(Person.NOTA_MIN== p.getMark());
		
		p.setMark(10);
		assertTrue(Person.NOTA_MAX == p.getMark());
		
		p.setMark(0);
		assertTrue(Person.NOTA_MIN== p.getMark());
		
		p.setMark(5);
		assertTrue(5 == p.getMark());
	}
	
	@Test
	public void testPersonNameGender() {
		
		Person p= new Person("carlos",'o');
		assertEquals("carlos",p.getName());
		assertEquals('I',p.getGender());
		
		p= new Person("carlos",'i');
		assertEquals("carlos",p.getName());
		assertEquals('I',p.getGender());
		
		p= new Person(null,'h');
		assertEquals("Sin nombre",p.getName());
		assertEquals('H',p.getGender());
		
		p= new Person("",'m');
		assertEquals("Sin nombre",p.getName());
		assertEquals('M',p.getGender());

	}

}
