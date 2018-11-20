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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	

}
