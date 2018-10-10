package com.ipartek.formacion.youtube.pojo;

public class Video {

	public static final int COD_LONGITUD = 11;

	private long id;
	private String cod;
	private String nombre;
	
	private Usuario usuario;

	//	CONSTRUCTORES
	public Video() {
		super();
		this.id = -1;
		this.cod = "";
		this.nombre = "";
		this.usuario = new Usuario();
	}

	public Video(String codigo, String nombre, Usuario usuario) throws Exception {
		this();
		this.id = -1;
		this.setCod(codigo);
		this.nombre = nombre;
		this.usuario = usuario;
	}
	
	//	GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) throws Exception {
		if (cod != null && cod.length() == COD_LONGITUD) {
			this.cod = cod;
		} else {
			throw new Exception("El CÓDIGO del video debe ser exactamente de " + COD_LONGITUD + " caracteres");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
