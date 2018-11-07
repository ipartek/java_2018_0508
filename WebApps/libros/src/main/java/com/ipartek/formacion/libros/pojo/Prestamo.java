package com.ipartek.formacion.libros.pojo;

import java.sql.Date;

public class Prestamo {

	private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
	
	private long id ;
	private Alumno alumno;
	private Libro libro;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaRetorno;

	public Prestamo() {
		super();
		this.id = -1;
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
	
	public Prestamo(int id,Alumno alumno, Libro libro, Date fechaInicio, Date fechaFin, boolean estado) {
		this();
		this.id = id;
		this.alumno = alumno;
		this.libro = libro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;

	}
	
	public void setId(long l) {
		this.id = l;
	}
	
	public long getId() {
		return id;
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

	public int getDiasRestantes() {
		 
		java.util.Date fechaInicial= new java.util.Date();
		java.util.Date fechaFinal= new java.util.Date(fechaFin.getTime());
 
		int dias=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/MILLSECS_PER_DAY);
		
		return dias;
	}

	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", alumno=" + alumno + ", libro=" + libro + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", fechaRetorno=" + fechaRetorno + "]";
	}
	

}
