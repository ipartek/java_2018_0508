package ETT;

public class Contratado extends Persona {

	private String numeroSS;
	private final float PORCENTAJE_SALARIO = 0.5f;
	
	public Contratado() {
		super();
		numeroSS = "";

	}

	public Contratado(String nombre, String dni, float salario, String numeroSS) throws Exception {
		super(nombre, dni, salario);
		this.setNumeroSS(numeroSS);
	}


	@Override
	public float calcularSalario() {
		return this.getSalario()* PORCENTAJE_SALARIO;
	}

	public String getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(String numeroSS) throws Exception {
		if(numeroSS=="") {
			this.numeroSS = numeroSS;
		}else {
			throw new Exception("ERROR el numero de la seguridad social esta vacio");
		}
		
	}
	
	

}
