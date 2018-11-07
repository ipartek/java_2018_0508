package com.ipartek.formacion.pojo;

public class Libro {
	private long id;
	private String titulo;
	private String isbn;
	private int cant;
	private Editorial editorial;

	public Libro() {
		super();
		this.id = -1;
		this.titulo = "";
		this.isbn = "";
		this.cant = 1;
		this.editorial = new Editorial();
	}

	public Libro(long id, String titulo, String isbn, int cant, Editorial editorial) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.cant = cant;
		this.editorial = editorial;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", cant=" + cant + ", editorial="
				+ editorial + "]";
	}

}
