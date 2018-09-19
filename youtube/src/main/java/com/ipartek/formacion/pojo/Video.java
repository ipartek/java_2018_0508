package com.ipartek.formacion.pojo;

import java.util.ArrayList;

public class Video {
	
	private String id;
	private String nombreCancion;
	private ArrayList<Comentarios> comentarios;

	
	
	public Video() throws Exception {
		super();
		this.id = "";
		this.nombreCancion = "";

	}
	
	public Video(String id, String nombreCancion) throws Exception {
		this();
		this.setId(id);
		this.setNombreCancion(nombreCancion);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) throws Exception {
		try {
			if(id != null && id.length() == 11) {
				this.id = id;
			}else {
				throw new Exception("El id debe contener 11 caracteres");
			}
		} catch (Exception e) {
			System.out.println("El identificador debe tener 11 caracteres");
			
		}
		
		
	}
	public String getNombreCancion() {
		return nombreCancion;
	}
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}
	
	public void setComentarios(Comentarios comentario) {
		this.comentarios.add(comentario);
	}
	
	public ArrayList<Comentarios> getComentarios() {
		return comentarios;
	}
	

}
