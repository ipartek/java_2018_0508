package com.ipartek.formacion.youtube.pojo;

public class Rol {
	
	public static int ID_ROL_ADMIN = 1;
	public static int ID_ROL_USER = 2;

	private long id;
	private String nombre;
	
	//	CONSTRUCTORES
	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}
	
	public Rol ( long id ) {
		
		this();
		this.id = id;
		
	}

	public Rol(int id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
	}

	//	GETTERS AND SETTERS
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
	

}
