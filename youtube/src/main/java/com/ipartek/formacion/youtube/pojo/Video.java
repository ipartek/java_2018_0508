package com.ipartek.formacion.youtube.pojo;

public class Video {

	public static final int ID_LONGITUD = 11;

	private long id;
	private String codigo;
	private String nombre;
	private long idUsuario;

	public Video() throws Exception {
		super();
		this.id = -1;
		this.setCodigo("YlUKcNNmywk");
		this.nombre = "Red Hot Chili Peppers - Californication";
		this.idUsuario = -1;
	}

	public Video(String codigo, String nombre, long idUsuario) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.idUsuario = idUsuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if (codigo != null && codigo.length() == ID_LONGITUD) {
			this.codigo = codigo;
		} else {
			throw new Exception("El ID debe ser exactamente de " + ID_LONGITUD + " caracteres");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
