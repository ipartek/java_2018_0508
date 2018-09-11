package com.ipartek.formacion.nidea.pojo;

public class Producto {
	
	private static long id;
	private String nombre;
	private String codigo;
	private String descripcion;
	private boolean oferta;
	private float precio;
	private String imagen;
	
	public Producto() {
		super();
		this.id = -1;
		this.nombre="";
		this.codigo="";
		this.descripcion="";
		this.oferta=false;
		this.precio=0;
		this.imagen ="https://cdn.miposicionamientoweb.es/wp-content/uploads/2015/12/bancos-de-imagenes-gratis-para-tu-blog.jpg";
	}
	public Producto(String nombre, String codigo, boolean oferta, float precio, String imagen) {
		super();
		this.id = getId();
		this.nombre = nombre;
		this.codigo = codigo;
		this.oferta = oferta;
		this.precio = precio;
		this.imagen = imagen;
	}

	
	public void setId() {
		this.id = ++id;
	}
	public long getId() {
		return ++id;
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
		return "Producto [nombre=" + nombre + ", codigo=" + codigo  + ", oferta="
				+ oferta + ", precio=" + precio + ", imagen=" + imagen + "]";
	}
	
	
}
