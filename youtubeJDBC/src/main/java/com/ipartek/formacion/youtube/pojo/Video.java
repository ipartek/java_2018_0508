package com.ipartek.formacion.youtube.pojo;

public class Video {

	public static final int CODIGO_LONGITUD = 11;
	
	private long id;
	private String codigo;
	private String nombre;
	private Usuario usuario;
	//private String thumbnail; // primera imagen del video http://img.youtube.com/vi/ID/0.jpg
	
	public Video() throws Exception {
		super();
		this.id = -1;
		this.codigo="";
		this.nombre = "";
		this.usuario = new Usuario();
	}
	
	public Video(String codigo, String nombre) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.usuario = new Usuario();
	}
	
	public Video(String codigo, String nombre,Usuario usuario_id) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.usuario = usuario_id;
	}


	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario_id) {
		this.usuario = usuario_id;
	}

	public void setCodigo(String codigo) throws Exception {
		if ( codigo != null && codigo.length() == CODIGO_LONGITUD ) {
			this.codigo = codigo;
		}else {
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

	@Override
	public String toString() {
		return "Video [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", usuario=" + usuario + "]";
	}

	
	
	
}
