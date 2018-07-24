package com.ipartek.formacion.pojo;

/***
 * Pojo que represente a usuario, un usuario va a tener (todos private) un Long
 * id, String nombre, String email, String password constructores, getters,
 * setters, tostring UsuarioDAO implements Crudable
 * 
 * @author Curso
 *
 */
public class Usuario {

	private Long id;
	private String nombre;
	private String email;
	private String password;

	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}
}
