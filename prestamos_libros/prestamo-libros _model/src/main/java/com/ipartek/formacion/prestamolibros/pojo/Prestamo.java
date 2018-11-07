package com.ipartek.formacion.prestamolibros.pojo;

import java.sql.Date;
import java.util.Calendar;

public class Prestamo {
	private Alumno alumno;
	private Libro libro;
	private Date fechaInicio;
	private Date fechaFin;
	private Date devuelto;
	private int diasRestantes;
	
	
	public Prestamo() {
		super();
		this.alumno = new Alumno();
		this.libro = new Libro();
		this.fechaInicio=new Date(Calendar.getInstance().getTime().getTime());
		this.fechaFin=new Date(Calendar.getInstance().getTime().getTime()); 
		this.devuelto=null;
		this.setDiasRestantes();
		
	}


	public Prestamo(Alumno alumno, Libro libro, Date fechaInicio, Date fechaFin,Date fechaDevuelto) {
		super();
		this.alumno = alumno;
		this.libro = libro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.setDiasRestantes();
		
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public Date getDevuelto() {
		return devuelto;
	}


	public void setDevuelto(Date devuelto) {
		this.devuelto = devuelto;
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


	public int getDiasRestantes() {
		return diasRestantes;
	}


	public void setDiasRestantes() {
		java.util.Date actual=new Date(Calendar.getInstance().getTime().getTime());
		this.diasRestantes = (int) (1+(this.getFechaFin().getTime() - actual.getTime())/86400000);
	}


	@Override
	public String toString() {
		return "Prestamo [alumno=" + alumno + ", libro=" + libro + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", devuelto=" + devuelto + ", diasRestantes=" + diasRestantes + "]";
	}

	
	
}
