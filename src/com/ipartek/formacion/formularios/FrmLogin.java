package com.ipartek.formacion.formularios;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrmLogin extends JFrame {

	
	private static final long serialVersionUID = 1L;

	JTextField tfUsuario;
	JTextField tfPsw;

	JLabel lblUsuario;
	JLabel lblPsw;

	/*
	public static void main(String args[]) {
		
		FrmLogin ventana = new FrmLogin();
	}*/
	
	public FrmLogin() {
		
		cargarVentana();
		inicializarVentana();
		
	}
	
	private void inicializarVentana() {
		
		lblUsuario = new JLabel("Usuario: ");
		this.add(lblUsuario);
		
		tfUsuario = new JTextField(50);
		this.add(tfUsuario);
		
		lblPsw = new JLabel("Password: ");
		this.add(lblPsw);
		
		tfPsw =  new JTextField(50);
		this.add(tfPsw);
		
		
	}

	private void cargarVentana() {
		
		setTitle("Login: ");
		setBounds(200, 200, 400, 400);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
