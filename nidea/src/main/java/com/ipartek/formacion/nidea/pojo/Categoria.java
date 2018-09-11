package com.ipartek.formacion.nidea.pojo;

public class Categoria {
	private long id;
	private String codigo;
	private String nombre;
	
	
	public Categoria() {
		super();
		this.id=-1;
		this.codigo="";
		this.nombre="S";
		
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
	
	
}
