package com.ipartek.formacion.prestamos_libros.pojo;

import java.sql.Date;

public class Prestamo {
	private Libro libro;
	private Usuario usuario;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Date fecha_devuelto;
	private long diasRestantes;
	
	

	public Prestamo() {
		super();
	}

	public Prestamo(Libro libro, Usuario usuario, Date fecha_inicio, Date fecha_fin, Date fecha_devuelto) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
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

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fech_fin) {
		this.fecha_fin = fech_fin;
	}

	public Date getFecha_devuelto() {
		return fecha_devuelto;
	}

	public void setFecha_devuelto(Date fecha_devuelto) {
		this.fecha_devuelto = fecha_devuelto;
	}

	@Override
	public String toString() {
		return "Prestamo [libro=" + libro + ", usuario=" + usuario + ", fecha_inicio=" + fecha_inicio + ", fecha_fin="
				+ fecha_fin + ", fecha_devuelto=" + fecha_devuelto + "]";
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
		result = prime * result + ((fecha_fin == null) ? 0 : fecha_fin.hashCode());
		result = prime * result + ((fecha_inicio == null) ? 0 : fecha_inicio.hashCode());
		result = prime * result + ((fecha_devuelto == null) ? 0 : fecha_devuelto.hashCode());
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
		if (fecha_fin == null) {
			if (other.fecha_fin != null)
				return false;
		} else if (!fecha_fin.equals(other.fecha_fin))
			return false;
		if (fecha_inicio == null) {
			if (other.fecha_inicio != null)
				return false;
		} else if (!fecha_inicio.equals(other.fecha_inicio))
			return false;
		if (fecha_devuelto == null) {
			if (other.fecha_devuelto != null)
				return false;
		} else if (!fecha_devuelto.equals(other.fecha_devuelto))
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
