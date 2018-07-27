package com.ipartek.formacion.pojo;

	

public class Video {
	
	private String id;
	private String nombreCancion;
	private String nombreAutor;
	
	
	public Video() throws Exception {
		super();
		this.setId(id);
		this.nombreCancion = "";

	}
	
	public Video(String id, String nombreCancion) throws Exception {
		this();
		this.id = id;
		this.nombreCancion = nombreCancion;

	}

	public String getId() {
		return id;
	}
	public void setId(String id) throws Exception {
		if(id != null && id.length() == 11) {
			this.id = id;
		}else {
			throw new Exception("El id debe contener 11 caracteres");
		}
		
	}
	public String getNombreCancion() {
		return nombreCancion;
	}
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

}
