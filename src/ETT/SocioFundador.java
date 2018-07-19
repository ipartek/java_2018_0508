package ETT;

public class SocioFundador extends Persona {

	private final float PORCENTAJE_SALARIO = 3.0f;
	
	public SocioFundador() {
		super();
	}
	
	public SocioFundador(String nombre, String dni, float salario) throws Exception {
		super(nombre, dni, salario);
		
	}

	@Override
	float calcularSalario() {
		return this.getSalario()*PORCENTAJE_SALARIO;
	}

}
