package com.ipartek.formacion.youtube.pojo;

public class Video {

	public static final int CODIGO_LONGITUD = 11;
	
	private long id;
	private String codigo;
	private String nombre;
	private UsuarioPrivado usuario;
	
	
	public Video() {
		super();
		this.id = -1;
		this.codigo="";
		this.nombre = "Surf Search Spot 2 0 video promo";
		this.usuario= new UsuarioPrivado();
		
	}
	
	public Video(String codigo, String nombre,UsuarioPrivado usuario) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
		this.usuario=usuario;
		
	}
	
	public Video(String codigo, String nombre) throws Exception {
		this();
		this.id = -1;
		this.setCodigo(codigo);
		this.nombre = nombre;
		
	}


	public Video(long videoId) {
		this();
		this.id=videoId;
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

	public UsuarioPrivado getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioPrivado usuarrio) {
		this.usuario = usuarrio;
	}

	
	
	@Override
	public String toString() {
		return "Video [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", usuarrio=" + usuario + "]";
	}

	
	
	
}
