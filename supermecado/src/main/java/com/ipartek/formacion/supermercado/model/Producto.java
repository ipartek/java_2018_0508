package com.ipartek.formacion.supermercado.model;

public class Producto {
	
	private long id;
	private String nombre;
	private float precio;
	private int descuento;  // 0 - 100
    private String imagen;
    private String precioUnidad; // precio por litro, precio por kg, etc... 
    private String descripcion;
    
    
	public Producto() {
		super();
		this.id = -1;
		this.nombre = "";
		this.imagen = "images/default_product.png";
		this.precioUnidad = "";
		this.descripcion = "";
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


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getDescuento() {
		return descuento;
	}


	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getPrecioUnidad() {
		return precioUnidad;
	}


	public void setPrecioUnidad(String precioUnidad) {
		this.precioUnidad = precioUnidad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", imagen=" + imagen + ", precioUnidad=" + precioUnidad + ", descripcion=" + descripcion + "]";
	}
		
}
