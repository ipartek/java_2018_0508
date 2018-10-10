package com.ipartek.formacion.youtube;

public class Video {

	public static final int CODIGO_LONGITUD = 11;

	private long id;
	private String codigo;
	private String nombre;
	private Usuario usuario;
	// añadir un atibuto de tipo usuario

	// https://img.youtube.com/vi/HSpeF-Bu26E/0.jpg

	public Video() throws Exception {
		super();
		this.id = -1;
		this.setCodigo("LPDhuthFD98");
		this.nombre = "Surf Search Spot 2 0 video promo";
		this.usuario = new Usuario();
	}

	// crear un constructor que se inicialice tambien con el usuario
	public Video(String codigo, String nombre, Usuario usuario) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.usuario = usuario;
	}

	public void setCodigo(String codigo) throws Exception {
		if (codigo != null && codigo.length() == CODIGO_LONGITUD) {
			this.codigo = codigo;
		} else {
			throw new Exception("El IDENTIFICADOR debe ser exactamente de " + CODIGO_LONGITUD + " caracteres");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	// añadir getters y setters de usuario

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}

}