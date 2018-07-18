package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class Person implements Serializable{
	
	//Constantes
	
	private static final long serialVersionUID = 1L;
	public final static char SEXO_INDEFINIDO = 'i';
	public final static char SEXO_MUJER = 'm';
	public final static char SEXO_HOMBRE = 'h';
	
	public final static float NOTA_MINIMA = 0.0f;
	public final static float NOTA_MAXIMA = 10.0f;
	
	public final static int EDAD_MINIMA = 18;
	public final static int EDAD_MAXIMA = 65;
	
	//Atributos
		
	private String nombre;
	private String apellido;
	private char sexo; //Hombre('h'), Mujer('m') e Indefinido('i')
	private int edad;
	private float nota;//Entre 0 y 10
	
	//Consntructores
	
	public Person(){
		super();
		this.setNombre("Sin Nombre");
		this.setApellido("");
		this.setSexo(SEXO_INDEFINIDO);
		this.setEdad(EDAD_MINIMA);
		this.setNota(NOTA_MINIMA); // Se puede castear a float poniendo f detr�s o (float) por delante.
	}
	
	//Constructor sobrecargado, mismo nombre pero diferentes pr�metros y mismo return
	public Person(String nombre) {
		this();
		this.setNombre(nombre);
	}
	
	public Person(String nombre, char sexo) {
		this();
		this.setNombre(nombre);
		this.setSexo(sexo);
	}
	
	public Person(String nombre,String apellido, char sexo) {
		this();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setSexo(sexo);
	}

	//getters y setters
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = (nombre != null)? nombre : "";
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido.trim();
	}

	public char getSexo() {
		return sexo;
	}

	/**
	 * Setea el sexo de la persona, podemos usar 'h' hombre, 'm' mujer, tanto may�sculas como min�sculas.
	 * En caso de no pasar esos valores ser� una 'i' de indefinido.
	 * @see constantes: SEXO_HOMBRE, SEXO_MUJER, SEXO_INDEFINIDO
	 * @param sexo char caracter que indica el sexo de Person.
	 */
	public void setSexo(char sexo) {
		
		sexo = Character.toLowerCase(sexo);
		
		switch (sexo) {
		
		case Person.SEXO_HOMBRE:
			this.sexo = Person.SEXO_HOMBRE;
			break;
			
		case Person.SEXO_MUJER:
			this.sexo = Person.SEXO_MUJER;
			break;

		default:
			this.sexo = Person.SEXO_INDEFINIDO;
			break;
		}
		
		/*if(Person.SEXO_HOMBRE == sexo) {
			this.sexo = Person.SEXO_HOMBRE;
		}
		else if(Person.SEXO_MUJER == sexo) {
			this.sexo = Person.SEXO_MUJER;
		}
		else {
			this.sexo = Person.SEXO_INDEFINIDO;
		}*/
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {

		if(edad <= EDAD_MINIMA) {
			this.edad = EDAD_MINIMA;
		}
		else if(edad >= EDAD_MAXIMA) {
			this.edad = EDAD_MAXIMA;
		}
		else {
			this.edad = edad;
		}

	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		
		if(nota <= NOTA_MINIMA) {
			this.nota = NOTA_MINIMA;
		}
		
		else if(nota >= NOTA_MAXIMA) {
			this.nota = NOTA_MAXIMA;
		}
		
		else {
			this.nota = nota;
		}
		
	}
	
	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", edad=" + edad +
				", nota=" + nota + "]";
	}

	
}
