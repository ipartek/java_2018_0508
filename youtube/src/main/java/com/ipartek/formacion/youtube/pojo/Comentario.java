package com.ipartek.formacion.youtube.pojo;

import java.util.Date;

public class Comentario {

	private Usuario usuario;
	private String comentario;
	private String idVideo;
	private Date fechaPublicacion;
	
	public Comentario() {
		super();
	}

	public Comentario(Usuario usuario, String comentario, Date fecha_publicacion) {
		this();
		this.usuario = usuario;
		this.comentario = comentario.trim();
		this.fechaPublicacion = fecha_publicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fecha_publicacion) {
		this.fechaPublicacion = fecha_publicacion;
	}

}
