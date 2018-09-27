package com.ipartek.formacion.youtube.pojo;

public class Video {

	public static final int ID_LONGITUD = 11;
	
	private long id;
	private String codigo;
	private String nombre;
	
	public Video() {
		super();
		this.id = -1;
		this.codigo="AAAAAAAAAAA";
		this.nombre = "Red Hot Chili Peppers - Californication";		
	}

	public Video(String codigo, String nombre) {
		super();
		this.id = -1;
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

	public void setCodigo(String codigo) throws Exception {
		if ( codigo != null && codigo.length() == ID_LONGITUD ) {
			this.codigo = codigo;
		}else {
			throw new Exception("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
