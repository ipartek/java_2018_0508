package com.ipartek.formacion.gestiondocente.pojo;

import java.sql.Date;

public class Imparticion {
	
	private int codigo;
	private Curso curso;
	private Alumno alumno;
	private Date fMatriculacion;
	
	public Imparticion() {
		super();
		this.codigo = 0;
		this.curso = null;
		this.alumno = null;
		this.fMatriculacion = null;
	}
	
	public Imparticion(int codigo, Curso curso, Alumno alumno, Date fMatriculacion) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.alumno = alumno;
		this.fMatriculacion = fMatriculacion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Date getfMatriculacion() {
		return fMatriculacion;
	}
	public void setfMatriculacion(Date fMatriculacion) {
		this.fMatriculacion = fMatriculacion;
	}
	@Override
	public String toString() {
		return "Imparticion [codigo=" + codigo + ", curso=" + curso + ", alumno=" + alumno + ", fMatriculacion="
				+ fMatriculacion + "]";
	}
	
	
	

}
