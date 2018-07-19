package com.ipartek.formacion.ett;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonaTest {

	SocioFundador mock1;
	static final String MOCK1_NOMBRE = "Socio Fundador";
	static final String MOCK1_DNI = "123456789-D";
	static final float MOCK1_SALARIO = 5000f;

	Secretaria mock2;
	static final String MOCK2_NOMBRE = "Secretaria";
	static final String MOCK2_DNI = "987654321-A";
	static final int MOCK2_EDAD = 35;
	static final float MOCK2_SALARIO = 1000f;

	Contratado mock3;
	static final String MOCK3_NOMBRE = "Socio Fundador";
	static final String MOCK3_DNI = "192837465-B";
	static final String MOCK3_NSS = "202020202020B";
	static final float MOCK3_SALARIO = 600f;

	@Before
	public void setUp() throws Exception {

		mock1 = new SocioFundador();
		mock1.setNombre(MOCK1_NOMBRE);
		mock1.setDni(MOCK1_DNI);
		mock1.setSalario(MOCK1_SALARIO);

		mock2 = new Secretaria();
		mock2.setNombre(MOCK2_NOMBRE);
		mock2.setDni(MOCK2_DNI);
		mock2.setEdad(MOCK2_EDAD);
		mock2.setSalario(MOCK2_SALARIO);

		mock3 = new Contratado();
		mock3.setNombre(MOCK3_NOMBRE);
		mock3.setDni(MOCK3_DNI);
		mock3.setNss(MOCK3_NSS);
		mock3.setSalario(MOCK3_SALARIO);
	}

	@After
	public void tearDown() throws Exception {

		mock1 = null;
		mock2 = null;
		mock3 = null;
	}

	@Test
	public void testCalculaSalario() {

		assertEquals(300f, mock3.calcularSalario(), 0);
		
		assertEquals((MOCK2_SALARIO*0.8f-MOCK2_EDAD), mock2.calcularSalario(), 0);
		
		assertEquals(MOCK1_SALARIO*3, mock1.calcularSalario(), 0);
		
		
	}

}
