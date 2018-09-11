package com.ipartek.formacion.nidea.pojo;

public class Producto {
	private String nombre;
	private String codigo;
	private String descripcion;
	private boolean oferta;
	private float precio;
	private String imagen;
	
	
	
	public Producto() {
		super();
		this.nombre="";
		this.codigo="";
		this.descripcion="";
		this.oferta=false;
		this.precio=0;
		this.imagen="images/openBox-512.png";
	}



	public Producto(String nombre, String codigo, String descripcion, boolean oferta, float precio) {
		this();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.oferta = oferta;
		this.precio = precio;
		
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



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public boolean isOferta() {
		return oferta;
	}



	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion + ", oferta="
				+ oferta + ", precio=" + precio + ", imagen=" + imagen + "]";
	}
	
	
}
