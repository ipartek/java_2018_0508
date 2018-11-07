package com.ipartek.formacion.libros.pojo;

import java.util.Date;

public class Prestamo {
	private Alumno alumno;
	private Libro libro;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean estado;

	public Prestamo() {
		super();
		this.alumno = new Alumno();
		this.libro = new Libro();
		this.estado = false;
	}

	public Prestamo(Alumno alumno, Libro libro, Date fechaInicio, Date fechaFin, boolean estado) {
		this();
		this.alumno = alumno;
		this.libro = libro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Prestamo [alumno=" + alumno + ", libro=" + libro + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", estado=" + estado + "]";
	}

}
