package ETT;

public class Secretaria extends Persona {

	private int edad;
	private final float PORCENTAJE_SALARIO = 0.8f;

	public Secretaria() {
		super();
		edad = 0;
	}

	public Secretaria(String nombre, String dni, float salario, int edad) throws Exception {
		super(nombre, dni, salario);
		

	}

	@Override
	float calcularSalario() {
		return (this.getSalario() * PORCENTAJE_SALARIO) - this.getEdad();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) throws Exception {
		if (edad > 0) {
			this.edad = edad;
		} else {
			throw new Exception("ERROR la edad es cero o menor");
			
		}
	}

}
