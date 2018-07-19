package com.ipartek.formacion.ejercicios.ett;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EttTest {
	static Contratado c = new Contratado();

	@Test
	public void testSalario() {
		//Contratado c = new Contratado();
		assertEquals(600, c.getSalario());

//		Persona p = new Persona("653425", "Asier", 1000);
	//	assertEquals(765, p.getSalario());

		//Persona p = new Persona("555555", "Eneko", 5000);
		//assertEquals(15000, p.getSalario());

	}
}