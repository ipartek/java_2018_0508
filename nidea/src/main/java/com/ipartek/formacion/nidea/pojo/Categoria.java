package com.ipartek.formacion.nidea.pojo;

import java.util.ArrayList;

public class Categoria {
	private long id;
	private String codigo;
	private String nombre;

	public Categoria() {
		super();
		this.id = -1;
		this.codigo = "";
		this.nombre = "";
	}

	public Categoria(long id, String codigo, String nombre) {
		this();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	public static ArrayList<Categoria> recuperarCategorias() {
		ArrayList<Categoria>list = new ArrayList<>();
		list.add(new Categoria(1,"c","Cocina"));
		list.add(new Categoria(2,"s","Salon"));
		list.add(new Categoria(3,"w","WC"));


		return list;
	}
}
