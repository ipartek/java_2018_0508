package com.ipartek.formacion.ett;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	SocioFundador mock1; // Prueba la Clase SocioFundador
	static final String MOCK1_NOMBRE = "Socio Fundador";
	static final String MOCK1_DNI = "123456789-D";
	static final float MOCK1_SALARIO = 5000f;

	Secretaria mock2; // Prueba la Clase Secretaria
	static final String MOCK2_NOMBRE = "Secretaria";
	static final String MOCK2_DNI = "987654321-A";
	static final int MOCK2_EDAD = 35;
	static final float MOCK2_SALARIO = 1000f;

	Contratado mock3; // Prueba la Clase Contratado
	static final String MOCK3_NOMBRE = "Socio Fundador";
	static final String MOCK3_DNI = "192837465-B";
	static final String MOCK3_NSS = "202020202020B";
	static final float MOCK3_SALARIO = 600f;

	@Before
	public void setUp() throws Exception {

		mock1 = new SocioFundador(MOCK1_NOMBRE, MOCK1_DNI, MOCK1_SALARIO);

		mock2 = new Secretaria(MOCK2_NOMBRE, MOCK2_DNI, MOCK2_SALARIO, MOCK2_EDAD);

		mock3 = new Contratado(MOCK3_NOMBRE, MOCK3_DNI, MOCK3_SALARIO, MOCK3_NSS);
	}

	@After
	public void tearDown() throws Exception {

		mock1 = null;
		mock2 = null;
		mock3 = null;
	}

	@Test
	public void testCalculaSalario() {

		assertEquals(MOCK3_SALARIO / 2f, mock3.calcularSalario(), 0); // Salario Contratado

		assertEquals((MOCK2_SALARIO * 0.8f - MOCK2_EDAD), mock2.calcularSalario(), 0); // Salario Secretaria

		assertEquals(MOCK1_SALARIO * 3f, mock1.calcularSalario(), 0); // Salario SocioFundador

	}

}
