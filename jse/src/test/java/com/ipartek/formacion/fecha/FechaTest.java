package com.ipartek.formacion.fecha;

import static org.junit.Assert.*;

import org.junit.Test;

public class FechaTest {

	@Test
	public void test() {

		Fecha f1 = new Fecha(1992, 10, 28);

		assertTrue(f1.getAno() == 1992);
		assertTrue(f1.getMes() == 10);
		assertTrue(f1.getDia() == 28);
	}

}
