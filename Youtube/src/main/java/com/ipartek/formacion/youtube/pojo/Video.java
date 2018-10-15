package com.ipartek.formacion.youtube.pojo;

import java.util.ArrayList;

public class Video {

	public static final int COD_LONGITUD = 11;

	private long id;
	private String cod;
	private String nombre;
	
	private Usuario usuario;
	private ArrayList<Comentario> comentarios;

	//	CONSTRUCTORES
	public Video() {
		super();
		this.id = -1;
		this.cod = "";
		this.nombre = "";
		this.usuario = new Usuario();
	}

	public Video(String codigo, String nombre, Usuario usuario) throws Exception {
		this();
		this.id = -1;
		this.setCod(codigo);
		this.nombre = nombre;
		this.usuario = usuario;
	}
	
	//	GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) throws Exception {
		if (cod != null && cod.length() == COD_LONGITUD) {
			this.cod = cod;
		} else {
			throw new Exception("El CÓDIGO del video debe ser exactamente de " + COD_LONGITUD + " caracteres");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		return "Video [id=" + id + ", cod=" + cod + ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + (int) (id ^ (id >>> 32));
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj != null && obj instanceof Video) {
			
			if (((Video) obj).getId() == this.id) {
				
				result = true;
			}
		}
		
		return result;
	}	

}
