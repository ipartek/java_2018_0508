package com.ipartek.formacion.videos;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ipartek.formacion.model.VideoYoutubeArrayDao;
import com.ipartek.formacion.pojo.videoYoutube;

public class GestorVideos {
	static videoYoutube[] videos = new videoYoutube[5];
	static VideoYoutubeArrayDao dao;

	public static void main(String[] args) throws Exception {

		cargarMenu();
	}

	private static void pintarMenu() throws Exception {
		int opcion;
		System.out.println("-----------------------");
		System.out.println("-------Youtube---------");
		System.out.println("-------Opciones--------");
		System.out.println("------1: Listar--------");
		System.out.println("------2: Añadir--------");
		System.out.println("------3: Eliminar------");
		System.out.println("------Seleccione una opcion------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		opcion = Integer.parseInt(br.readLine());
		dao = VideoYoutubeArrayDao.getInstance();
		if (opcion == 1) {
			listarCanciones();
		}else {
			if (opcion == 2) {
				Anadir();
			}
		}

	}

	private static void cargarMenu() throws Exception {
		
		/*for(int i= 0; i > 6;i++) {
			videoYoutube cancionVideo = new videoYoutube();
			videos[0] = cancionVideo;
	}*/
		pintarMenu();
	}

	private static void Anadir() throws Exception {
		char agregarMas = 0 ;
		/*videoYoutube test = new videoYoutube();
		videos[0] = test;*/
		long id;
		String cancion;
		String codigo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do{
			
		System.out.println("------Opcion añadir------");
		
		System.out.println("------Introduzca el id de la cancion------");
		id = Long.parseLong(br.readLine());


		System.out.println("------Introduzca el nombre de la cancion------");
		cancion = br.readLine();
		
		System.out.println("------Introduzca el codigo de la cancion------");
		codigo = br.readLine();
		
		// Con los datos de la cancion deberiamos crear un objeto dao
		videoYoutube test1 = new videoYoutube(id,cancion ,codigo );
		//dao.add(id,cancion ,codigo);
		//dao.add(test1);
		dao.insert(test1);

			
			System.out.println("------Quiere añadir otra cancion------");
			agregarMas = (char)br.read();
			
		}while (agregarMas == 'S' || agregarMas == 's');
		
		
		
		//videoYoutube test = new videoYoutube(cancion,codigo);
		//System.out.println(test.getTitulo() +"-"+ test.getCodigo());
		

	}
	private static void listarCanciones() {
		videoYoutube vInicial1 = new videoYoutube(1,"Agua de marzo" ,"rap1" );
		videoYoutube vInicial2 = new videoYoutube(1,"Repartiendo arte" ,"rap2" );
		videoYoutube vInicial3 = new videoYoutube(1,"Cancion3" ,"rap3" );
		videoYoutube vInicial4 = new videoYoutube(1,"Cancion4" ,"rap4" );
		videoYoutube vInicial5 = new videoYoutube(1,"Cancion5" ,"raps5" );
		dao.insert(vInicial1);
		dao.insert(vInicial2);
		dao.insert(vInicial3);
		dao.insert(vInicial4);
		dao.insert(vInicial5);
		System.out.println(dao);
		System.out.println("------Listar Menu------");
		for (int x= 0 ; x < videos.length; x++) {
			System.out.println(videos[x]);
			//System.out.println(test1.getCodigo() + " - " + test1.getTitulo()+" "+ test1.getId());
		}
		//System.out.println(videos.getTitulo() +"-"+ test.getCodigo());
		

	}
}
