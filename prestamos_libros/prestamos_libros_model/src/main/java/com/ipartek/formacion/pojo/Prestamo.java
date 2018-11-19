package com.ipartek.formacion.pojo;

import java.sql.Date;
import java.util.Calendar;

public class Prestamo {
	private long id;

	private Libro libro;

	private Alumno alumno;

	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_devuelto;

	public Prestamo() {
		super();
		this.id = -1;
		this.alumno = new Alumno();
		this.libro = new Libro();
		this.fecha_inicio = new Date(Calendar.getInstance().getTime().getTime());
		this.fecha_fin = new Date(Calendar.getInstance().getTime().getTime());
		this.fecha_devuelto = new Date(Calendar.getInstance().getTime().getTime());
	}

	public Prestamo(long id, Libro libro, Alumno alumno, Date fecha_inicio, Date fecha_fin, Date fecha_devuelto) {
		super();
		this.id = id;
		this.libro = libro;
		this.alumno = alumno;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_devuelto = fecha_devuelto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_devuelto() {
		return fecha_devuelto;
	}

	public void setFecha_devuelto(Date fecha_devuelto) {
		this.fecha_devuelto = fecha_devuelto;
	}
	public int diasRestantes() {
		

		int dias=(int) ((fecha_fin.getTime() - Calendar.getInstance().getTime().getTime())/86400000);
		
		return dias;
	}
	

	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", libro=" + libro + ", alumno=" + alumno + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", fecha_devuelto=" + fecha_devuelto + "]";
	}



}