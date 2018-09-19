package com.ipartek.formacion.pojo;

public class Comentarios {
	private String autor;
	private String comentario;
	private String videoId;

	public Comentarios() {
		super();
		this.autor = "";
		this.comentario = "";
		this.videoId = "";

	}

	public Comentarios(String autor, String comentario, String videoId) {
		this();
		this.autor = autor;
		this.comentario = comentario;
		this.videoId = videoId;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

}
