package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class Person implements Serializable {

	
	private static final long serialVersionUID = 1L;
	// Constantes
	public final static char SEXO_INDEFINIDO = 'I';
	public final static char SEXO_MUJER = 'M';
	public final static char SEXO_HOMBRE = 'H';
	public final static float NOTA_MINIMA = 0.0f;
	public final static float NOTA_MAXIMA = 10.0f;
	public final static int EDAD_MINIMA = 18;
	public final static int EDAD_MAXIMA = 65;

	// Atributos

	private String nombre;
	private String apellido;
	private char sexo;
	private int edad;
	private float nota;// 0 y 10

	// Constructores

	public Person() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.sexo = SEXO_INDEFINIDO;
		this.edad = EDAD_MINIMA;
		this.nota = NOTA_MINIMA;
	}

	public Person(String nombre, char sexo) {
		this();
		this.setNombre(nombre);
		this.setSexo(sexo);
	}

	public Person(String nombre, String apellido, char sexo) {
		this();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setSexo(sexo);
	}

	// Getters y Setters
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = (nombre != null) ? nombre : "";
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = (apellido != null) ? apellido : "";
	}

	public char getSexo() {
		return sexo;
	}

	/**
	 * Setea el sexo de la persona, podemos usar 'h' hombre, 'm' mujer , (tanto
	 * mayusculas como minusculas). En caso de no pasar esos valores ser� 'i' de
	 * indefinido.
	 * 
	 * @see constantes: SEXO_HOMBRE , SEXO_MUJER , SEXO_INDEFINIDO
	 * @param sexo char caracter que indica el sexo de Person
	 */
	public void setSexo(char sexo) {

		sexo = Character.toUpperCase(sexo);
		switch (sexo) {
		case SEXO_HOMBRE:
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

		switch (edad) {
		case EDAD_MAXIMA:
		case EDAD_MINIMA:
			this.edad = edad;
			break;

		default:
			this.edad = (edad < EDAD_MINIMA) ? EDAD_MINIMA : (edad > EDAD_MAXIMA) ? EDAD_MAXIMA : edad;
			break;
		}

	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {

		this.nota = (nota < NOTA_MINIMA) ? NOTA_MINIMA : (nota > NOTA_MAXIMA ? NOTA_MAXIMA : nota);
	}

	// METODOS
	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + "," + ", edad=" + edad
				+ ", nota=" + nota + "]";
	}
}
