package ETT;

abstract class Persona {

	private String nombre;
	private String dni;
	private float salario;

	public Persona() {
		super();
		this.nombre = "";
		this.dni = "";
		this.salario = 0;

	}

	public Persona(String nombre, String dni, float salario) throws Exception {
		this();
		this.setNombre(nombre);
		this.setDni(dni);
		this.salario = salario;
	}
	
	abstract float calcularSalario();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if (nombre != "") {
			this.nombre = nombre;
		} else {
			throw new Exception("ERROR nombre vacio");
		}
	}

	public String getDni() {
		return dni;

	}

	public void setDni(String dni) throws Exception {
		if (dni.length() == 9) {
			this.dni = dni;
		} else {
			throw new Exception("ERROR dni con tamaño incorrecto");
		}
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
