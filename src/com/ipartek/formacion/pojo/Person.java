package com.ipartek.formacion.pojo;

public class Person {

	// constantes
	public final static char SEXO_INDEFINIDO = 'i';
	public final static char SEXO_MUJER = 'm';
	public final static char SEXO_HOMBRE = 'h';

	public final static float NOTA_MINIMA = 0.0f;
	public final static float NOTA_MAXIMA = 10.0f;

	// Atributos

	// TODO nueva atributo edad => 16 y 100

	private String nombre;

	private String apellido;

	private char sexo;

	private int edad;

	private float nota;

	public Person() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.sexo = SEXO_INDEFINIDO;
		this.edad = 0;
		this.nota = NOTA_MINIMA;
	}

	public Person(String nombre) {
		this();
		this.nombre = nombre;
	}

	public Person(String nombre, char sexo) {
		this();
		this.setNombre(nombre);
		this.setSexo(sexo);
	}

	public Person(String nombre, String apellidos, char sexo) {
		this();
		this.setNombre(nombre);
		this.setApellido(apellidos);
		this.setSexo(sexo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = (nombre != null) ? nombre : "";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = (apellido != null) ? apellido : "";
	}

	public char getSexo() {
		return sexo;
	}

	/**
	 * Setear el sexo de la persona, podemos usar 'h' hombre, 'm' mujer ( tanto
	 * mayusculas como minusculas). * En caso de no pasar pasar esos valores será
	 * 'i' indefinido.
	 * 
	 * @see constnates: SEXO_INDEFINIDO, SEXO_MUJER, SEXO_HOMBRE
	 * @param sexo char character que indica el sexo Person
	 * 
	 */
	public void setSexo(char sexo) {

		sexo = Character.toLowerCase(sexo);
		switch (sexo) {
		case SEXO_HOMBRE:
			this.sexo = sexo;
			break;

		case SEXO_MUJER:
			this.sexo = sexo;
			break;

		default:
			this.sexo = SEXO_INDEFINIDO;
			break;
		}

	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {

		if (nota < NOTA_MINIMA) {
			this.nota = NOTA_MINIMA;

		} else if (nota > NOTA_MAXIMA) {
			this.nota = NOTA_MAXIMA;

		} else {
			this.nota = nota;
		}

	}

	@Override	
	public String toString() {
		return "Person [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", edad=" + edad + ", nota="
				+ nota + "]";
	}

}
