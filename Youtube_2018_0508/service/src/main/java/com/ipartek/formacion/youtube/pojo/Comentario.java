package com.ipartek.formacion.youtube.pojo;

import java.util.Date;

public class Comentario {
	private long id;
	private Date fecha;
	private String texto;
	private boolean aprobado;
	private Video video;
	private Usuario usuario;
	
	public Comentario() {
		super();
		this.id = -1;
		this.fecha = null;
		this.texto = "";
		this.aprobado = false;
		this.video = new Video();
		this.usuario = new Usuario();
	}

	public Comentario(long id, Date fecha, String contenido) {
		this();
		this.id = id;
		this.fecha = fecha;
		this.texto = contenido;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
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
		return "Comentario [id=" + id + ", fecha=" + fecha + ", texto=" + texto + ", video=" + video + ", usuario="
				+ usuario + "]";
	}
}
