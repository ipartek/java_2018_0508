package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Constantes
	public final static char SEXO_INDEFINIDO = 'I';
	public final static char SEXO_MUJER = 'M';
	public final static char SEXO_HOMBRE = 'H';

	public final static float NOTA_MIN = 0.0f;
	public final static float NOTA_MAX = 10.0f;

	// Atributos
	
	private String name;
	private String surname;
	private char gender; // M-H-I
	private int age;
	private float mark; // 0.0-10.00

	public Person() {
		this.name = "Sin nombre";
		this.surname = "Sin apellido";
		this.gender = SEXO_INDEFINIDO;
		this.age = 0;
		this.mark = NOTA_MIN;
	}

	public Person(String name) {
		this();
		this.setName(name);

	}
	
	public Person(String name,char gender) {
		this();
		this.setName(name);
		this.setGender(gender);

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public char getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public float getMark() {
		return mark;
	}

	public void setName(String name) {
		this.name = (name==null || name=="")?"Sin nombre":name.trim();
	}

	public void setSurname(String surname) {
		this.surname = (surname==null || surname=="")?"Sin apellido":surname.trim();
	}

	
	/**
	 * Setea el sexo de la persona, podemos usar H - Hombre, M - Mujer (tanto matus. como minus.)
	 * En caso de  no pasar esos valores, sera I - Indefinido
	 * @param gender char character que indica el sexo de Person
	 * @see constantes: SEXO_INDEFINIDO, SEXO_HOMBRE, SEXO_MUJER
	 */
	public void setGender(char gender) {
		
		/*
		this.gender = (Character.toUpperCase(gender) == SEXO_HOMBRE || Character.toUpperCase(gender) == SEXO_MUJER
				|| Character.toUpperCase(gender) == SEXO_INDEFINIDO) ? Character.toUpperCase(gender) : SEXO_INDEFINIDO;
		 */
		gender=Character.toUpperCase(gender);
		switch(gender){
			case SEXO_HOMBRE:
			case SEXO_MUJER: 
				this.gender=gender;
				break;
			default:
				this.gender=SEXO_INDEFINIDO;
			}
	
	}
	public void setAge(int age) {
		this.age = (age < 0) ? 0 : age;
	}

	public void setMark(float mark) {
		this.mark = (mark <= NOTA_MIN) ? 0 : ((mark >= NOTA_MAX) ? 10 : mark);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", gender=" + gender + ", age=" + age + ", mark="
				+ mark + "]";
	}

}
