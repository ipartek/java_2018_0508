package com.ipartek.formacion.youtube.pojo;

public class Comentario {
	
	private String texto;

	public Comentario() {
		super();
		this.texto = "";
	}

	public Comentario(String texto) {
		super();
		this.texto = texto;
	}

	public String gettexto() {
		return texto;
	}

	public void settexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "texto [texto=" + texto + "]";
	}

}
