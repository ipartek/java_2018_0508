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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fech_inicio == null) ? 0 : fech_inicio.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (fech_inicio == null) {
			if (other.fech_inicio != null)
				return false;
		} else if (!fech_inicio.equals(other.fech_inicio))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	
}
