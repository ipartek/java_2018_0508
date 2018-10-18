package com.ipartek.formacion.youtube.pojo;

import java.sql.Date;

public class Usuario {
	
	public static final int STATUS_ELIMINADO = 0;
	public static final int STATUS_ACTIVO = 1;
	
	private long id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Date fecha_alta;
	private String descripcion;
	private String imagen;
	private String alias;
	private String password;
	private String email;
	private String direccion;
	private int status;
	
	
	private Rol rol; // 1: Admin, 2: Usuario

	// CONSTRUCTORES
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.password = "";
		this.rol = new Rol();
	}

	public Usuario(String alias, String password) {
		this();
		this.alias = alias;
		this.password = password;
	}

	// GETTERS AND SETTERS
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	// OVERRIDES
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fecha_alta=" + fecha_alta + ", descripcion=" + descripcion + ", imagen=" + imagen + ", alias="
				+ alias + ", password=" + password + ", email=" + email + ", direccion=" + direccion + "status=" + status + ", rol=" + rol + "]";
	}

	

}
