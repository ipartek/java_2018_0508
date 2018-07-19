package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class PruebasTest {
	
	//test
	public void testPasoPorValor() { //con variables primitivas
		
		int i1=5;
		int i2=5;
		
		assertTrue(i1==i2);
		
		int suma= sumaUno(i1);
		assertTrue(i1==5);
		assertTrue(suma==6);
	
	}
	
	private int sumaUno(int i1) {
		
		return ++i1;
	}
	
public void testPasoPorReferencia() { //con instancias
		
		Integer i1= new Integer(5);
		Integer i2= new Integer(5);
		
		assertFalse(i1==i2); //compara posicion de memoria, i1 no es igual a i2
		assertEquals(i1,i2); //compara valor interno
		
		VideoYoutube v= new VideoYoutube();
		v.setId(5);
		VideoYoutube referencia= sumaUno(v);
		
		assertTrue(6==v.getId());
		assertTrue(referencia==v); //referencia y v son iguales porque apuntan al mismo sitio de memoria
	}

    private VideoYoutube sumaUno(VideoYoutube video) {
    	
    	video.setId(6);
    	return video;
    }
    
    //test
    public void testEqualsVideo() {
    	
    	VideoYoutube v1= new VideoYoutube();
    	VideoYoutube v2= new VideoYoutube();
    	
    	assertTrue(v1!=v2);
    	assertTrue(v1.equals(v2)); 
    }

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
