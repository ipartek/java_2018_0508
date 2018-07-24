package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Constantes
	public final static char SEX_INDEFINIDO = 'i';
	public final static char SEX_HOMBRE = 'h';
	public final static char SEX_MUJER = 'm';
	
	public final static float NOTA_MINIMA = 0.0f;
	public final static float NOTA_MAXIMA = 10.0f;
	
	public final static int EDAD_MINIMA = 18;
	public final static int EDAD_MAXIMA = 65;
	
	//Atributos
	private String nombre;
	private String apellido;
	private char sexo;// ("M", "F", "I");
	private int edad;
	private float nota;//0,0-10,0
	
	
	//Constructores
	public Person(){
		super();
		this.nombre = "";
		this.apellido = "";
		this.sexo = SEX_INDEFINIDO;
		this.edad = 0;
		this.nota = NOTA_MINIMA;
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
		this.nombre = (nombre != null)? nombre:null;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = (apellido != null)? apellido:null;;
	}


	public char getSexo() {
		return sexo;
	}

/**
 * Setea el sexo de la persona. Podemos usar 'h' hombre,'m' mujer (tanto en mayusculas como en minisculas).
 * En caso de no pasar esos valores sera 'i' indefinido.
 * @see Constatnes: SEX_INDEFINIDO, SEX_HOMBRE, SEX_MUJER.
 * @param sexo char caracter que indica el sexo de Person.
 */
	public void setSexo(char sexo) {
		/*METODO IF
		 * sexo = Character.toLowerCase(sexo);
		if (Person.SEX_HOMBRE == sexo) {
			this.sexo = Person.SEX_HOMBRE;
		}else if (Person.SEX_MUJER == sexo){
			this.sexo = Person.SEX_MUJER;
		}else
			this.sexo = Person.SEX_INDEFINIDO;*/
		
		/*SWICH*/
		sexo = Character.toLowerCase(sexo);
		switch (sexo){
		case SEX_HOMBRE:
			this.sexo = Person.SEX_HOMBRE;
			break;
		case SEX_MUJER:
			this.sexo = Person.SEX_MUJER;
			break;
		default:
			this.sexo = Person.SEX_INDEFINIDO;
			break;
		}
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		if (edad<EDAD_MINIMA) {
			edad = EDAD_MINIMA;
		}else if (edad>EDAD_MAXIMA) {
		    edad = EDAD_MAXIMA;
		}else {
			this.edad = edad;
		}
	}


	public float getNota() {
		return nota;
	}


	public void setNota(float nota) {
		if (nota<NOTA_MINIMA) {
			nota = NOTA_MINIMA;
		}else if (nota>NOTA_MAXIMA) {
		    nota = NOTA_MAXIMA;
		}else {
			this.nota = nota;
		}
	}


	@Override
	public String toString() {
		return "Person [nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + ", edad=" + edad + ", nota="
				+ nota + "]";
	}
	
}