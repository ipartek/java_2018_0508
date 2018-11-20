package com.ipartek.formacion.prestamos_libros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	private long id;
	@NotBlank
	@Size(min=2, max=150)
	private String nombreApellido;

	public Usuario() {
		super();
	}

	public Usuario(long id, String nombreApellido) {
		super();
		this.id = id;
		this.nombreApellido = nombreApellido;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreApellido=" + nombreApellido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombreApellido == null) ? 0 : nombreApellido.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (nombreApellido == null) {
			if (other.nombreApellido != null)
				return false;
		} else if (!nombreApellido.equals(other.nombreApellido))
			return false;
		return true;
	}
	
	

}
