package com.ipartek.formacion.ejercicios.video;

import java.util.List;

import com.ipartek.formacion.model.VideoYoutubeArrayDAO;
import com.ipartek.formacion.pojo.Youtube;

public class YoutubeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VideoYoutubeArrayDAO y = VideoYoutubeArrayDAO.getIntance();
		
		Youtube video1 = new Youtube(13, "Pintxo", "asdf");
		Youtube video2 = new Youtube(16, "Fito", "asdf");
		Youtube video3 = new Youtube(20, "Nach", "asdf");
		Youtube video4 = new Youtube(30, "Marea", "Perro viejo");
		
		y.insert(video1);
		y.insert(video2);
		y.insert(video3);
		y.insert(video4);
		
		Youtube v = y.getByID(13);
		System.out.println(v.toString());
		
		y.delete(13);
		
		List<Youtube> videos = y.getAll();
		
		for(int i=0;i<videos.size();i++) {
			Youtube vid = videos.get(i);
			System.out.println(vid.toString());
		}
		
		video3.setTitulo("Nach Scratch");
		
		y.update(video3);
		
		videos = y.getAll();
		
		for(int i=0;i<videos.size();i++) {
			Youtube vid = videos.get(i);
			System.out.println(vid.toString());
		}

	}

}
