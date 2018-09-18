package com.ipartek.formacion.youtube.pojo;

public class Video {
	
	public static final int ID_LENGTH = 11;
	public static final String ID_MENSAJE_EXCEPTION = "La longitud exacta del ID debe ser " + ID_LENGTH;
	
	private String id;
	private String nombre;
	
	public Video() {
		super();
		this.id = "1w7OgIMMRc4";
		this.nombre = "Guns N' Roses - Sweet Child O' Mine";
	}
	
	public Video(String id, String nombre) throws Exception {
		this();
		this.setId(id);
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		
		if(id != null && id.trim().length() == ID_LENGTH) {
			this.id = id;
		}else {
			throw new Exception(ID_MENSAJE_EXCEPTION);
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
		return "Youtube [id=" + id + ", nombre=" + nombre + "]";
	}

}
