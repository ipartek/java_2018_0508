package com.ipartek.formacion.supermercado.model;

public class Producto {
	
	private long id;
	private String nombre;
	private float precio;
	private int descuento;  //De 0 a 100
	private String imagen;
	private String precioUnidad; //Precio por litro, por kilo...etc.
	private String descripcion;
	
	public Producto() {
		super();
		this.id = -1;
		this.nombre = "";
		this.imagen = "images/default_product.png";
		this.precioUnidad = "";
		this.descripcion = "";
	}
	
	public Producto(long id, String nombre, float precio, int descuento, String imagen, String precioUnidad,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.imagen = imagen;
		this.precioUnidad = precioUnidad;
		this.descripcion = descripcion;
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
	
	public float getCalcularDescuento() {
		
		float precio = 0;
		
		precio = this.precio - ((this.precio * this.descuento) / 100);
		
		precio = (float) (Math.round(precio * 100.0)/100.0);
		
		return precio;
		
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", Nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", imagen=" + imagen + ", precioUnidad=" + precioUnidad + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
