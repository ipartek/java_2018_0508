package tiempoejecuciontest;

public class Util {

	private static Util INSTANCE = null;

	public static synchronized Util getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Util();
		}
		return INSTANCE;
	}

	public static int convertir(long tiempo) {

		System.out.println("Pasa por util");
		long startTime;

		return 0;
	}

}
