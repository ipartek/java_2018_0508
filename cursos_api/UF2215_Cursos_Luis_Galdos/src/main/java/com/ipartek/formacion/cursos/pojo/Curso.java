package com.ipartek.formacion.cursos.pojo;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private long codigo;
	private String identificador;
	private String nombre;

	private float numHoras;
	private Profesor profesor;
	private ArrayList<Alumno> alumnos;

	public Curso() {
		super();
		this.codigo = -1;
		this.identificador = "";
		this.nombre = "";
		this.numHoras = 0;
		this.profesor = new Profesor();
		this.alumnos = new ArrayList<Alumno>();
	}

	public Curso(String identificador, String nombre, float numHoras) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.numHoras = numHoras;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getNumHoras() {
		return numHoras;
	}

	public void setNumHoras(float numHoras) {
		this.numHoras = numHoras;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [identificador=" + identificador + ", nombre=" + nombre + ", numHoras=" + numHoras + ", profesor="
				+ profesor + ", alumnos=" + alumnos + "]";
	}

}
