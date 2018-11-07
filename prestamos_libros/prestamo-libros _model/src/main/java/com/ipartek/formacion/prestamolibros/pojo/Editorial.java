package com.ipartek.formacion.prestamolibros.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Editorial {
	
	@NotBlank
	@Size(min=2, max=50)
	private String editorial;
	
	private long id;

	public Editorial() {
		super();
		this.editorial = "";
		this.id=-1;
	}

	public Editorial(String editorial, long id) {
		this();
		this.editorial = editorial;
		this.id=id;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Editorial [editorial=" + editorial + ", id=" + id + "]";
	}

	

}
