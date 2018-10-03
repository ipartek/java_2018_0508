package com.ipartek.formacion.examenLibro.model;

public class Pagina {
	private String texto;
	private Usuario usuario;

	public Pagina(String texto, Usuario usuario) {
		super();
		this.texto = texto;
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pagina [texto=" + texto + ", usuario=" + usuario + "]";
	}

}
