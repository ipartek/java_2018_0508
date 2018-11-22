package com.ipartek.formacion.gestiondocente.pojo;

public class Profesor {
	private int codigo;
	private int nss;


	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String poblacion;
	private String codigoPostal;
	private String telefono;
	private String email;
	private int activo;
	
	
	public Profesor() {
		super();
		this.codigo = 0;
		this.nss = 0;
		this.nombre = "";
		this.apellidos = "";
		this.dni = "";
		this.direccion = "";
		this.poblacion = "";
		this.codigoPostal = "";
		this.telefono = "";
		this.email = "";
		this.activo = 0;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNss() {
		return nss;
	}
	public void setNss(int nss) {
		this.nss = nss;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Profesor [codigo=" + codigo + ", nss=" + nss + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigoPostal="
				+ codigoPostal + ", telefono=" + telefono + ", email=" + email + ", activo=" + activo + "]";
	}
	
		
	
	
}
