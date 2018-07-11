package com.ipartek.formacion.videos;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ipartek.formacion.pojo.VideoYoutube;

public class GestorVideos {
	
	static VideoYoutube videos[] = new VideoYoutube[4];
	
	
	public static void main(String[] args) {
		pintarMenu();
		cargarVideos();
	}

	private static void cargarVideos() {
		// crear y guardar 5 videos en el array
		videos[0] = new VideoYoutube(1, "Qzw6A2WC5Qo", "Feel invincible");
		videos[1] = new VideoYoutube(2, "SKnRdQiH3-k", "The resistance");
		videos[2] = new VideoYoutube(3, "njJ7NZMH70M", "Not gonna die");
		videos[3] = new VideoYoutube(4, "b3jQ0tFqG_0", "Rise");
		
		for(int i =0; i< videos.length; i++) {
			System.out.println(videos[i]);
		}
	}

	private static void pintarMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean salir = false;
	
		System.out.println("-------------------------");
		System.out.println("------YOUTUBE------");
		System.out.println("-------------------------");
		while(!salir) {
			System.out.println("1. Listar");
			System.out.println("2. Añadir");
			System.out.println("3. Eliminar");
			System.out.println("4. Salir");
			
			try {
				System.out.print("Elige una opcion ");
				int opcion = sc.nextInt();
				
				switch (opcion) {
				case 1:
					System.out.println("Has elegido la opcion 1");
					break;
				case 2:
					System.out.println("Has elegido la opcion 2");
					break;
				case 3:
					System.out.println("Has elegido la opcion 3");
					break;
				case 4:
					salir = true;
					break;
				default:
					System.out.println("Solo numeros del 1 al 4");
			}
			}catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
			}
		}
		
		sc.close();
	}

	
}
