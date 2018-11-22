package com.ipartek.formacion.gestiondocente.pojo;

public class Cliente {

	private int codigo;
	private String nombre;
	private String email;
	private String telefono;
	private String direccion;
	private String poblacion;
	private String codigoPostal;
	private String identificador;
	private int activo;
	
	

	public Cliente() {
		super();
		this.codigo = -1;
		this.nombre = "";
		this.email = "";
		this.telefono = "";
		this.direccion = "";
		this.poblacion = "";
		this.codigoPostal = "";
		this.identificador = "";
		this.activo = 0;
	}

	public Cliente(int codigo, String nombre, String email, String telefono, String direccion, String poblacion,
			String codigoPostal, String identificador, int activo) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.identificador = identificador;
		this.activo = activo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal
				+ ", identificador=" + identificador + ", activo=" + activo + "]";
	}
	

}
