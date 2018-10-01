package com.ipartek.formacion.youtube;

public class Comentario {
	private Usuario usuario;
	private String comentario;
	
	public Comentario(Usuario usuario, String comentario) {
		this.usuario = usuario;
		this.comentario = comentario;
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
	
	@Override
	public String toString() {
		return "Comentario [usuario=" + usuario + ", comentario=" + comentario + "]";
	}
	
}
