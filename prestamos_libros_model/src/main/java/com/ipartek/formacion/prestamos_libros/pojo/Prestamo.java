package com.ipartek.formacion.prestamos_libros.pojo;

import java.sql.Date;

public class Prestamo {
	private Date fecha_prestado;
	private Date fecha_fin; //Trigger + 15 dias
	private Date fecha_retorno; 
	private Alumno alumno;
	private Libro libro;
	
	public Prestamo() {
		super();
		this.fecha_prestado = null;
		this.fecha_fin = null;
		this.fecha_retorno = null;
		this.alumno = new Alumno();
		this.libro = new Libro();
	}
	
	public Prestamo(Date fecha_inicio, Alumno alumno, Libro libro) {
		this();
		this.fecha_prestado = fecha_inicio;
		this.alumno = alumno;
		this.libro = libro;
	}
	
	public Date getFecha_prestado() {
		return fecha_prestado;
	}
	
	public void setFecha_prestado(Date fecha_prestado) {
		this.fecha_prestado = fecha_prestado;
	}
	
	public Date getFecha_fin() {
		return fecha_fin;
	}
	
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public Date getFecha_retorno() {
		return fecha_retorno;
	}

	public void setFecha_retorno(Date fecha_retorno) {
		this.fecha_retorno = fecha_retorno;
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

	@Override
	public String toString() {
		return "Prestamo [fecha_prestado=" + fecha_prestado + ", fecha_fin=" + fecha_fin + ", fecha_retorno="
				+ fecha_retorno + ", alumno=" + alumno + ", libro=" + libro + "]";
	}
}
