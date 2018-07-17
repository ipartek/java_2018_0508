package com.ipartek.formacion.pojo;

/**
 * Clase POJO para gestionar Personas.
 * 
 * @see package-info.java
 * @author Curso
 *
 */
public class Person {

	// CONSTANTES
	public static final char SEXO_INDEFINIDO = 'I';
	public static final char SEXO_HOMBRE = 'H';
	public static final char SEXO_MUJER = 'M';

	public static final float NOTA_MINIMA = 0.0F;
	public static final float NOTA_MAXIMA = 10.0F;

	public static final int EDAD_MINIMA = 18;
	public static final int EDAD_MAXIMA = 65;

	// ATRIBUTOS
	private String nombre;
	private String apellido;
	private char sexo;
	private int edad;
	private float nota;

	// CONSTRUCTOR(ES)
	public Person() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.sexo = SEXO_INDEFINIDO;
		this.edad = EDAD_MINIMA;
		this.nota = NOTA_MINIMA;
	}

	public Person(String nombre, String apellido) {
		this();
		this.nombre = nombre;
		this.setNombre(nombre);
		this.setApellido(apellido);

	}

	public Person(String nombre, String apellido, char sexo) {
		this();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setSexo(sexo);
	}

	// GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = (nombre == null) ? "" : nombre.trim();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = (apellido == null) ? "" : apellido.trim();

	}

	public char getSexo() {
		return sexo;
	}

	/**
	 * Establece el sexo de la persona, H = hombre, M = mujer, I = Indefinido,
	 * admite mayúsculas y minúsculas. Por defecto, el sexo es I.
	 * 
	 * @see constantes SEXO_INDEFINIDO, SEXO_HOMBRE, SEXO_MUJER
	 * @param sexo char, character que indica el sexo de Person
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

	/**
	 * Establece la edad de la persona. Si edad es menor que EDAD_MINIMA, entonces
	 * edad es igual a EDAD_MINIMA. Si edad es mayor que EDAD_MAXIMA, entonces nota
	 * vale EDAD_MAXIMA. Por defecto, nota vale EDAD_MINIMA
	 * 
	 * @see constantes EDAD_MINIMA, EDAD_MAXIMA
	 * @param edad, int que refleja la edad de la persona
	 */
	public void setEdad(int edad) {
		if (edad < EDAD_MINIMA) {
			this.edad = EDAD_MINIMA;
		} else if (edad > EDAD_MAXIMA) {
			this.edad = EDAD_MAXIMA;
		} else {
			this.edad = edad;
		}
	}

	public float getNota() {
		return nota;
	}

	/**
	 * Establece la nota de la persona. Si nota es menor que NOTA_MINIMA, entonces
	 * nota es igual a NOTA_MINIMA. Si nota es mayor que NOTA_MAXIMA, entonces nota
	 * vale NOTA_MAXIMA. Por defecto, nota vale NOTA_MINIMA
	 * 
	 * @see constantes NOTA_MINIMA, NOTA_MAXIMA
	 * @param nota float, indica la nota de la Persona
	 */
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
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", edad=" + edad + ", nota="
				+ nota + "]";
	}

}
