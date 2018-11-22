package com.ipartek.formacion.gestiondocentes.pojo;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private long codigo;
	private String nombre;
	private String identificador;
	private int nHoras;
	private Profesor profesor;
	private List<Alumno> alumnos;
	
	public Curso() {
		super();
		this.codigo = -1;
		this.nombre = "";
		this.identificador = "";
		this.nHoras = 0;
		this.profesor = new Profesor();
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public Curso(long codigo, String nombre, String identificador, int nHoras) {
		this();
		this.codigo = codigo;
		this.nombre = nombre;
		this.identificador = identificador;
		this.nHoras = nHoras;
	}
	
	public Curso(long codigo, String nombre, String identificador, int nHoras, Profesor profesor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.identificador = identificador;
		this.nHoras = nHoras;
		this.profesor = profesor;
	}

	public long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
	
	public int getnHoras() {
		return nHoras;
	}
	
	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
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

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", identificador=" + identificador + ", nHoras="
				+ nHoras + ", profesor=" + profesor + "]";
	}
}
