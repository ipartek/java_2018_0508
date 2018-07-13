package com.ipartek.formacion.model;

import com.ipartek.formacion.pojo.videoYoutube;


/**
 * 
 * @author drohne
 *
 */
public class Prueba {

	//public static VideoYoutubeArrayDao dao = null;
	static VideoYoutubeArrayDao dao;

	public static void main(String[] args) {
		// objeto de pruabs en java se llama moks ?
/*		videoYoutube mock1;
		long MOCK_ID = 13;
		String MOCK_TITULO = "El fary";
		String MOCK_CODIGO = "34jf";*/

		// insertar
		videoYoutube c1 = new videoYoutube(13, "pintxo pintxo", "3jpp");
		videoYoutube c2 = new videoYoutube(256, "Marijaia", "4f6");
		videoYoutube c3 = new videoYoutube(7, "Estrella polar", "78x949");
		dao.getById(13);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		dao.insert(c1);
		dao.insert(c2);
		dao.insert(c3);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		
		//
	}
}
