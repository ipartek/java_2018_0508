package ETT;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ETTTest {

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
		try {
			Contratado con = new Contratado("Luis","123456789",600,"345678");
			assertTrue(300 == con.getSalario());
			
			Secretaria se = new Secretaria("Asier","123456789",1000,35);
			assertTrue(800 == se.getSalario());
			
			SocioFundador sf = new SocioFundador("Eneko","123654789",5000);
			assertTrue(15000 == sf.getSalario());
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
