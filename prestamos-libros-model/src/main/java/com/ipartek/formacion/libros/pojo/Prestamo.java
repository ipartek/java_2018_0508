package com.ipartek.formacion.libros.pojo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Prestamo {

	@Override
	public Prestamo clone() throws CloneNotSupportedException {
		
		return (Prestamo) this.clone();
	}

	private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

	private Alumno alumno;
	private Libro libro;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaInicio;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaFin;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaRetorno;

	public Prestamo() {
		super();
		this.alumno = new Alumno();
		this.libro = new Libro();
	}

	public Prestamo(Alumno alumno, Libro libro, Date fechaInicio, Date fechaFin, boolean estado) {
		this();
		this.alumno = alumno;
		this.libro = libro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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

	public Date getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	public int diasRestantes() {

		java.util.Date fechaInicial = new java.util.Date();
		java.util.Date fechaFinal = new java.util.Date(fechaFin.getTime());

		int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / MILLSECS_PER_DAY);

		return dias;
	}

	@Override
	public String toString() {
		return "Prestamo [alumno=" + alumno + ", libro=" + libro + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", fechaRetorno=" + fechaRetorno + "]";
	}

}
