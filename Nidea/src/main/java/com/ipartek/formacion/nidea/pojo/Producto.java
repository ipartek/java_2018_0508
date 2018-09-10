package com.ipartek.formacion.nidea.pojo;

public class Producto {
	
	private String codigo;
	private String nombre;
	private String descripcion;
	private boolean esOferta;
	private float precio;
	private String img;
	
	// CONSTRUCTOR(es)
	public Producto() {
		super();
		this.codigo = "";
		this.nombre = "";
		this.descripcion = "";
		this.img = "";
	}
	
	public Producto(String codigo, String nombre, String descripcion, boolean esOferta, float precio, String img) {
		this();
		if (codigo != null) {
			this.codigo = codigo.trim();
		}
		if (this.nombre != null) {
			this.nombre = nombre.trim();
		}
		if (this.descripcion != null) {
			this.descripcion = descripcion.trim();
		}
		if (this.img != null) {
			this.img = img.trim();
		}
		
		this.esOferta = esOferta;
		this.precio = precio;
		
	}
	
	// GETTERS AND SETTERS
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo.trim();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.trim();
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.trim();
	}
	public boolean isEsOferta() {
		return esOferta;
	}
	public void setEsOferta(boolean esOferta) {
		this.esOferta = esOferta;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img.trim();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Código de Producto: " + "\t" + this.codigo);
		sb.append("\nNombre del Producto: "  + "\t" + this.nombre);
		sb.append("\nDescripción del Producto: "  + "\t" + this.descripcion);
		sb.append("\nPrecio: "  + "\t" + String.valueOf(precio));
		sb.append("\nOferta: "  + "\t");
		
		if (this.esOferta) {
			sb.append("Sí");
		} else {
			sb.append("No");
		}
		
		sb.append("\nImagen del producto: "  + "\t" + img);
		return sb.toString();
	}
	
	

}
