package com.ipartek.formacion.videos;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

import java.util.Scanner;

public class GestorVideos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cargarVideos();
		pintarMenu();
		
		
		boolean end = false;
		while (end==false) {
			
			String accion = sc.nextLine();
			switch (accion) {
		        case "1":  //Listar videos
		        	for (int i = 0; i < VideoYoutubeArrayDAO.getInstance().getAll().size(); i++) {
						System.out.println(VideoYoutubeArrayDAO.getInstance().getAll().get(i).getId() + " --> " + VideoYoutubeArrayDAO.getInstance().getAll().get(i).getTitulo());
					}
		        	System.out.println("¿Quieres realizar mas acciones?");
		        	break;
		        case "2":  //modificar video
		        	System.out.println("Introduce el identificador del video que deseas modificar: ");
		    		String identificador = sc.next();
		    		Integer id_int = Integer.valueOf(identificador);
		    		System.out.println("Introduce el nuevo titulo para el video con id: " + identificador);
		    		String titulo = sc.next();
		    		System.out.println("Introduce el nuevo codigo para el video con id: " + identificador);
		    		String codigo = sc.next();
		    		VideoYoutube video = VideoYoutubeArrayDAO.getInstance().getById(id_int);
		    		video.setCodigo(codigo);
		    		video.setTitulo(titulo);
		    		VideoYoutubeArrayDAO.getInstance().update(video);
		    		System.out.println("Video modificado con exito!!");
		    		System.out.println("¿Quieres realizar mas acciones? si/no");
		    		break;
		        case "3":  //guardar video
		        	System.out.println("Quieres guardar un video nuevo. Sigue los pasos a continuacion.");
		        	System.out.println("Introduce el identificador para el video, si esta repetido, no se introducirá:");
		        	String id = sc.next();
		        	id_int = Integer.valueOf(id);
		        	System.out.println("Introduce el titulo del video:");
		        	titulo = sc.next();
		        	System.out.println("Introduce el codigo del video:");
		        	codigo = sc.next();
		        	video = new VideoYoutube(id_int, titulo, codigo);
		        	VideoYoutubeArrayDAO.getInstance().getAll().add(video);
		        	System.out.println("Video guardado con exito!!");
		        	System.out.println("¿Quieres realizar mas acciones? si/no");
		        	break;
		        case "si": 
		        	pintarMenu();
		        	break;
		        case "no":
		        	System.out.println("El programa ha terminado su proceso. Ejecutalo otra vez si quieres realizar alguna acción");
		        	end = true;
		        	break;
		        case "finalizar":
		        	System.out.println("El programa ha terminado su proceso. Ejecutalo otra vez si quieres realizar alguna acción");
		        	end = true;
		        	break;
			}
		}
		sc.close();
	}

	
	private static void cargarVideos() {
		//TODO crear y guadar 5 videos en el array
		VideoYoutube video1 = new VideoYoutube(1, "primer video", "codigo 1");
		VideoYoutube video2 = new VideoYoutube(2, "segundo video", "codigo 2");
		VideoYoutube video3 = new VideoYoutube(3, "tercer video", "codigo 3");
		VideoYoutube video4 = new VideoYoutube(4, "cuarto video", "codigo 4");
		VideoYoutube video5 = new VideoYoutube(5, "quinto video", "codigo 5");
		
		VideoYoutubeArrayDAO.getInstance().insert(video1);
		VideoYoutubeArrayDAO.getInstance().insert(video2);
		VideoYoutubeArrayDAO.getInstance().insert(video3);
		VideoYoutubeArrayDAO.getInstance().insert(video4);
		VideoYoutubeArrayDAO.getInstance().insert(video5);
	}


	private static void pintarMenu() {
	
		//TODO pintar menu
		System.out.println("------------------------------------");
		System.out.println("--          youtube               --");
		System.out.println("------------------------------------");
		System.out.println("    1. Listar");
		System.out.println("------------------------------------");
		System.out.println("    2. Modificar");
		System.out.println("------------------------------------");
		System.out.println("    3. Guardar");
		System.out.println("------------------------------------");
		System.out.println("Introduce la accion que deseas realizar, si no quieres realizar ninguna accion, introduce 'finalizar':");
	}
	
}
