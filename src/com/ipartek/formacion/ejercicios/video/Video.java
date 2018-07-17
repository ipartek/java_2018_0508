package com.ipartek.formacion.ejercicios.video;

import java.util.Scanner;

import com.ipartek.formacion.pojo.Youtube;

public class Video {
	
	private static Youtube[] videos = new Youtube[5];
	
	public static void main(String[] args) {
		Youtube y = new Youtube(1, "Fito", "uyfjhg");
		
		videos[0] = y;
		
		mostrarMenu();
		
		Scanner p = new Scanner(System.in);
		int opcion = p.nextInt();
		
		if(comprobarOpcion(opcion)) {
			switch(opcion) {
			case 1:
				listarVideos();
				break;
			case 2:
				System.out.println("Ingresa un ID:");
				long id = p.nextLong();
				p.nextLine();
				System.out.println("Ingresa un titulo:" );
				String titulo = p.nextLine();
				
				System.out.println("Ingresa un codigo:");
				String codigo = p.nextLine();
				
				Youtube nuevoVideo = new Youtube(id, titulo, codigo);
				
				anadirVideo(nuevoVideo);
				
				break;
				
			case 3:
				System.out.println("Ingresa el ID para borrar:");
				long idBorrar = p.nextLong();
				eliminarVideo(idBorrar);
				break;
			}
		
			
		}else {
			System.out.println("Error");
		}
		
	}
	
	private static void mostrarMenu() {
		System.out.println("------------------------------------");
		System.out.println("------Selecciona una opción:--------");
		System.out.println("   1 - Listar");
		System.out.println("   2 - Añadir");
		System.out.println("   3 - Eliminar");
		
	}
	
	private static boolean comprobarOpcion(int opcion) {
		if(opcion > 0 && opcion < 4) {
			return true;
		}else {
			return false;
		}
	}
	
	private static void listarVideos() {
		for(int i=0; i<videos.length;i++) {
			if(videos[i]!=null) {
				System.out.println(videos[i].toString());
				
			}
		}
	}
	
	private static void anadirVideo(Youtube video) {
	

		
		for(int i=0;i<videos.length;i++) {
			if(videos[i]==null) {
				videos[i] = video;
				break;
			}
		}
		
		listarVideos();

	}
	
	private static void eliminarVideo(long id) {
		for(int i=0;i<videos.length;i++) {
			if(videos[i].getId() == id) {
				videos[i] = null;
				break;
			}
		}
		
		listarVideos();
	}

}
