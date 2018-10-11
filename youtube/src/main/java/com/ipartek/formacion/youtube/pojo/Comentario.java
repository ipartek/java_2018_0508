package com.ipartek.formacion.youtube.pojo;

import java.util.Date;
import java.sql.Timestamp;

public class Comentario {

	private long id;
	private String texto;
	private boolean aprobado;
	private Date fecha;
	
	private Video video; // FK Video
	private Usuario usuario; // FK Usuario
	
	// CONSTRUCTORES
	public Comentario() {
		super();
		this.id = -1;
		this.texto = "";
		this.aprobado = false;
		this.fecha = null;
		this.video = new Video();
		this.usuario = new Usuario();
	}

	public Comentario(String texto) {
		this();
		this.texto = texto;
	}

	// GETTERS AND SETTERS
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

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp timestamp) {
		this.fecha = timestamp;
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
	
	// OVERRIDES
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", texto=" + texto + ", aprobado=" + aprobado + ", fecha="
				+ fecha + ", video=" + video + ", usuario=" + usuario + "]";
	}
}
