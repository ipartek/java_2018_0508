package com.ipartek.formacion.nidea.pojo;

public class Categoria {

	private long id;
	private String nombre;
	private String codigo;

	public Categoria() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";

	}
	

	public Categoria(long id, String nombre, String codigo) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
	}

}
