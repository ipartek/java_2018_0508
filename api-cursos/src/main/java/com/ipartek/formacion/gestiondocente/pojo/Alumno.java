package com.ipartek.formacion.gestiondocente.pojo;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Alumno {
	
	private long codigo;
	private String nombre;
	
	private String apellidos;
	private Date fNacimiento;
	private String direccion;
	private String poblacion;
	private String codigoPostal;
	private String telefono;
	private String email;
	private String dni;
	private int nHermanos;
	private int activo;
	
	public Alumno() {
		this.codigo = -1;
		this.nombre = "";
		this.apellidos = "";
		this.fNacimiento = null;
		this.direccion = "";
		this.poblacion = "";
		this.codigoPostal = "";
		this.telefono = "";
		this.email = "";
		this.dni = "";
		this.nHermanos = 0;
		this.activo =0;
	}
	
	public Alumno(long codigo, String nombre, String apellidos, Date fNacimiento, String direccion, String poblacion,
			String codigoPostal, String telefono, String email, String dni, int nHermanos, int activo) {
		this();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
		this.nHermanos = nHermanos;
		this.activo = activo;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(int nHermanos) {
		this.nHermanos = nHermanos;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento="
				+ fNacimiento + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codigoPostal="
				+ codigoPostal + ", telefono=" + telefono + ", email=" + email + ", dni=" + dni + ", nHermanos="
				+ nHermanos + ", activo=" + activo + "]";
	}
	
	
	


	

	
	
}
