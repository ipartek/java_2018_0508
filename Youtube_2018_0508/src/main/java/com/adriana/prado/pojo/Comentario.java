package com.adriana.prado.pojo;

public class Comentario {
	private String id;
	private String fecha;
	private String contenido;
	//Clave Externa
	private String idVideo;
	private String nombreUsuario;
	
	public Comentario() {
		super();
		this.id = "";
		this.fecha = "";
		this.contenido = "";
		this.idVideo = "";
		this.nombreUsuario = "";
	}
	
	public Comentario(String id, String fecha, String contenido, String idVideo) {
		this();
		this.id = id;
		this.fecha = fecha;
		this.contenido = contenido;
		this.idVideo = idVideo;
	}
	
	public Comentario(String id, String fecha, String contenido, String idVideo, String nombreUsuario) {
		this();
		this.id = id;
		this.fecha = fecha;
		this.contenido = contenido;
		this.idVideo = idVideo;
		this.nombreUsuario = nombreUsuario;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public String getIdVideo() {
		return idVideo;
	}
	
	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}
	
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", fecha=" + fecha + ", contenido=" + contenido + ", idVideo=" + idVideo + "]";
	}
	
	
}
