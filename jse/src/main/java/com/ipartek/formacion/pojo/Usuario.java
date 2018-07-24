package com.ipartek.formacion.pojo;

/**
 * Clase POJO para gestionar Usuarios.
 * 
 * @see package-info.java
 * @author Curso
 *
 */
public class Usuario {

	// VARIABLES
	private long id;
	private String nombre;
	private String mail;
	private String psw;

	// CONSTRUCTORES
	public Usuario() {

		super();
		this.id = 0;
		this.nombre = "";
		this.mail = "";
		this.psw = "";
	}

	public Usuario(long id, String nombre, String mail, String psw) {

		this();
		setId(id);
		setNombre(nombre);
		setNombre(mail);
		setPsw(psw);
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {

		if (id != 0) {
			this.id = id;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null) {
			this.nombre = nombre.trim();
		}
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		if (mail != null) {
			this.mail = mail.trim();
		}
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		if (psw != null) {
			this.psw = psw.trim();
		}
	}

	// OTROS M�TODOS Y FUNCIONES

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((psw == null) ? 0 : psw.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (psw == null) {
			if (other.psw != null)
				return false;
		} else if (!psw.equals(other.psw))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", mail=" + mail + ", psw=" + psw + "]";
	}

} // FIN Usuario
