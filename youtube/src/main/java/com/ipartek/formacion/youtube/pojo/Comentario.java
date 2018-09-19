package com.ipartek.formacion.youtube.pojo;

import java.util.Date;

public class Comentario {

	private String texto;
	private Usuario dueno;
	private Date fecha;
	private Video video;
	
	
	
	public Comentario() {
		super();
	}



	public Comentario(String texto, Usuario dueno, Date fecha, Video video) {
		this();
		this.texto = texto;
		this.dueno = dueno;
		this.fecha = fecha;
		this.video= video;
	}



	public Video getVideo() {
		return video;
	}



	public void setVideo(Video video) {
		this.video = video;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	public Usuario getDueno() {
		return dueno;
	}



	public void setDueno(Usuario dueno) {
		this.dueno = dueno;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	@Override
	public String toString() {
		return "Comentario [texto=" + texto + ", dueno=" + dueno + ", fecha=" + fecha + "]";
	}
	
	
	
}
