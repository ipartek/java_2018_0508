package com.ipartek.formacion.youtube.pojo;

public class Video {

	public static final int CODIGO_LONGITUD = 11;
	
	private long id;
	private String codigo;
	private String nombre;
	
	public Video() throws Exception {
		super();
		this.id = -1;
		this.setCodigo("LPDhuthFD98");
		this.nombre = "Surf Search Spot 2 0 video promo";		
	}
	
	public Video(String codigo, String nombre) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
	}


	public void setCodigo(String codigo) throws Exception {
		if ( codigo != null && codigo.length() == CODIGO_LONGITUD ) {
			this.codigo = codigo;
		}else {
			throw new Exception("El IDENTIFICADOR debe ser exactamente de " + CODIGO_LONGITUD + " caracteres");
		}	
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

	@Override
	public String toString() {
		return "Video [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}
