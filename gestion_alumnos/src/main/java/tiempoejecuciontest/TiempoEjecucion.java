package tiempoejecuciontest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.repaso.service.AlumnoService;

public class TiempoEjecucion {

	AlumnoService servicioAlumno = new AlumnoService();
	static Util utilComprobar = new Util();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		utilComprobar = Util.getInstance();
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
		// fail("Not yet implemented");
	}

	@Test
	public void testConvertirTiempo() {
		utilComprobar.convertir(1000);
	}

}
