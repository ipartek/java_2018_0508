package com.ipartek.formacion.pojo;

import java.io.Serializable;

public class VideoYoutube implements Cloneable, Serializable {

	private static final long serialVersionUID = 3427309974850390851L;

	private static String MENSAJE_EXCEPTION_CODIGO = "El codigo debe ser de 11 caracteres";
	
	private long id;
	private String codigo; //11 caracteres
	private String titulo;

	public VideoYoutube() {
		super();
		this.id = -1;
		this.codigo = "";
		this.titulo = "";
	}

	public VideoYoutube(long id, String titulo, String codigo) throws Exception  {
		this();
		this.id = id;
		this.titulo = titulo;
		//this.codigo = codigo;
		setCodigo(codigo);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 * @throws Exception
	 */
	public void setCodigo(String codigo) throws Exception {
		
		if ( codigo != null ) {
			codigo = codigo.trim();				
			if ( codigo.length() != 11) {
				throw new Exception( MENSAJE_EXCEPTION_CODIGO );
			}else {
				this.codigo = codigo;				
			}
		} else {
			throw new Exception( MENSAJE_EXCEPTION_CODIGO );
		}	
		
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "VideoYoutube [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		VideoYoutube other = (VideoYoutube) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
