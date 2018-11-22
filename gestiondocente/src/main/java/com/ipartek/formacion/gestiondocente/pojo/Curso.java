package com.ipartek.formacion.gestiondocente.pojo;

import java.util.ArrayList;

public class Curso {

	private String nombre;
	private String identificador;
	private int horas;
	private Profesor profesor;
	private ArrayList<Alumno> alumnos;

	public Curso() {
		super();

		this.nombre = "";
		this.identificador = "";
		this.horas = 0;
		this.profesor = new Profesor();
		this.alumnos = new ArrayList<Alumno>();
	}

	public Curso(String nombre, String identificador, int horas, Profesor profesor, ArrayList<Alumno> alumnos) {
		this();
		this.nombre = nombre;
		this.identificador = identificador;
		this.horas = horas;
		this.profesor = profesor;
		this.alumnos = alumnos;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

}
