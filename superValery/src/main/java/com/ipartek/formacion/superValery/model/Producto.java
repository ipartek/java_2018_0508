package com.ipartek.formacion.superValery.model;

public class Producto {

	private long id;
	private String nombre;
	private float precio;
	private int descuento; // 0 - 100
	private String imagen;
	private float precioUnidad; // precio por litro, precio por kg, etc
	private String descripcion;

	public Producto() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0;
		this.descuento = 0;
		this.imagen = "imagenes/puertoIndias.jpg";
		this.precioUnidad = 0;
		this.descripcion = "";
	}
	
	
	public Producto(long id, String nombre, float precio, int descuento, String imagen, float precioUnidad,
			String descripcion) {
		this();
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

	public float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getCalcularDescuento() {
		return  Math.round(( this.precio - ( this.precio * this.descuento /100 ) ));
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", imagen=" + imagen + ", precioUnidad=" + precioUnidad + ", descripcion=" + descripcion + "]";
	}

}
