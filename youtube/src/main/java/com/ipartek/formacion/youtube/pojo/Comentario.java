package com.ipartek.formacion.youtube.pojo;

public class Comentario {
	
	private String comentario;

	public Comentario() {
		super();
		this.comentario = "";
	}

	public Comentario(String comentario) {
		super();
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Comentario [comentario=" + comentario + "]";
	}

}
