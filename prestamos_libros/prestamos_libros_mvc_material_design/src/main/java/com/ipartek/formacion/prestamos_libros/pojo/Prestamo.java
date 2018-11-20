package com.ipartek.formacion.prestamos_libros.pojo;

import java.sql.Date;

public class Prestamo {
	private Libro libro;
	private Usuario usuario;
	private Date fech_inicio;
	private Date fech_fin;
	private Date fecha_devuelto;
	private long diasRestantes;
	
	

	public Prestamo() {
		super();
	}

	public Prestamo(Libro libro, Usuario usuario, Date fech_inicio, Date fech_fin, Date fecha_devuelto) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fech_inicio = fech_inicio;
		this.fech_fin = fech_fin;
		this.fecha_devuelto = fecha_devuelto;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFech_inicio() {
		return fech_inicio;
	}

	public void setFech_inicio(Date fech_inicio) {
		this.fech_inicio = fech_inicio;
	}

	public Date getFech_fin() {
		return fech_fin;
	}

	public void setFech_fin(Date fech_fin) {
		this.fech_fin = fech_fin;
	}

	public Date getFecha_devuelto() {
		return fecha_devuelto;
	}

	public void setFecha_devuelto(Date fecha_devuelto) {
		this.fecha_devuelto = fecha_devuelto;
	}

	@Override
	public String toString() {
		return "Prestamo [libro=" + libro + ", usuario=" + usuario + ", fech_inicio=" + fech_inicio + ", fech_fin="
				+ fech_fin + ", fecha_devuelto=" + fecha_devuelto + "]";
	}

	public long getDiasRestantes() {
		return diasRestantes;
	}

	public void setDiasRestantes(long diasRestantes) {
		this.diasRestantes = diasRestantes;
	}

}
