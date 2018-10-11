package com.ipartek.formacion.youtube.pojo;

import java.util.Date;

public class Comentario {

	private long id;
	private String texto;
	private Date fecha;
	private boolean aprobado;
	private Video video;
	private Usuario usuario;
	
	public Comentario() {
		super();
		this.id = -1;
		this.texto = "";
		this.fecha = null;
		this.aprobado = false;
		this.video = new Video();
		this.usuario = new Usuario();
	}

	public Comentario(String texto, Video video, Usuario usuario) {
		super();
		this.texto = texto;
		this.video = video;
		this.usuario = usuario;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", fecha=" + fecha + ", aprobado=" + aprobado + ", video="
				+ video + ", usuario=" + usuario + "]";
	}
	
	
	
}
