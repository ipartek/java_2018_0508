package com.ipartek.formacion.ejercicios;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.VideoYoutube;

public class ComprobacionDAOyouTube {

	static VideoYoutubeArrayDAO dao = VideoYoutubeArrayDAO.getInstance();

	public static void main(String[] args) {

		VideoYoutube miVideo1, miVideo2, miVideo3;

		miVideo1 = new VideoYoutube(1L, "Pintxo pintxo", "XXXXX");
		miVideo2 = new VideoYoutube(2L, "La casa por el tejado", "YYYYY");
		miVideo3 = new VideoYoutube(3L, "uno x uno", "ZZZZZZZ");

		insertarVideo(miVideo1, miVideo2, miVideo3);
		mostrarVideo();
		eliminarVideo();
		modificarVideo();

	}

	public static void insertarVideo(VideoYoutube video1, VideoYoutube video2, VideoYoutube video3) {

		dao.insert(video1);
		dao.insert(video2);
		dao.insert(video3);

		for (VideoYoutube listVideos : dao.getALl()) {
			System.out.println(listVideos);
		}
	}

	public static void mostrarVideo() {

		// Recuperar y mostrar video con id 1
		System.out.println("El video con id " + 1 + " : " + dao.getById(1L));

	}

	public static void eliminarVideo() {

		dao.delete(1);
		System.out.println("Listado despues de eliminar video seleccionado:");

		for (VideoYoutube listVideos : dao.getALl()) {
			System.out.println(listVideos);
		}
	}

	public static void modificarVideo() {

		VideoYoutube miVideo1 = new VideoYoutube(2L, "LAlala", "YYYYYYY");
		dao.update(miVideo1);

		System.out.println(" ");
		System.out.println(
				"Listado despues de modificar el registro con id 2 con el titulo la casa por el tejado por Lalalala");

		for (VideoYoutube listVideos : dao.getALl()) {
			System.out.println(listVideos);
		}
	}

}
