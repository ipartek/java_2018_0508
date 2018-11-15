package com.ipartek.formacion.prestamos_libros.pojo;

public class Usuario {
	
	private Long id;
	private String nombre_apellidos;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre_apellidos) {
		super();
		this.id = id;
		this.nombre_apellidos = nombre_apellidos;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_apellidos() {
		return nombre_apellidos;
	}
	public void setNombre_apellidos(String nombre_apellidos) {
		this.nombre_apellidos = nombre_apellidos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre_apellidos=" + nombre_apellidos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre_apellidos == null) ? 0 : nombre_apellidos.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre_apellidos == null) {
			if (other.nombre_apellidos != null)
				return false;
		} else if (!nombre_apellidos.equals(other.nombre_apellidos))
			return false;
		return true;
	}

	
	
}
