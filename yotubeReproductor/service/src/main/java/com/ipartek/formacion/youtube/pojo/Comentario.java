package com.ipartek.formacion.youtube.pojo;

import java.util.Date;

public class Comentario {
	private long id;
	private Date fecha;
	private String texto;
	private boolean aprobado;
	private Usuario usuario;
	private Video video;
	

	public Comentario() {
		this.id = -1;
		this.fecha = null;
		this.texto = "";
		this.aprobado = false;
		this.usuario = new Usuario();
		this.video = new Video();
		
	}
	
	public Comentario(Date fecha, String texto, boolean aprobado, Usuario usuario, Video video) {
		this();
		this.id = -1;
		this.fecha = fecha;
		this.texto = texto;
		this.aprobado = aprobado;
		this.usuario = usuario;
		this.video = video;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", fecha=" + fecha + ", texto=" + texto + ", aprobado=" + aprobado
				+ ", usuario=" + usuario + ", video=" + video + "]";
	}

}
