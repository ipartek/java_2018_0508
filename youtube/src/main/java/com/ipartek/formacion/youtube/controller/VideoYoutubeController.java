package com.ipartek.formacion.youtube.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.VideoArrayListDao;
import com.ipartek.formacion.pojo.Video;

/**
 * Servlet implementation class VideoYoutubeController
 */
@WebServlet("/")
public class VideoYoutubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static VideoArrayListDao videosDao;
	private static ArrayList<Video> videos;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			videosDao = VideoArrayListDao.getInstance();
			videos = (ArrayList<Video>) videosDao.getAll();		
			Video v = new Video("AwsoXKP2HWE","El momo - sol de marzo");
			videosDao.insert(v);
			Video v2 = new Video("rC1KcJLRFDE","Shintoma - Somos de lo malo lo peor");
			videosDao.insert(v2);
			Video v3 = new Video("wWrXkBz74SU","Nach - Éxodo");
			videosDao.insert(v3);
			
			
			request.setAttribute("videos", videos);
			System.out.println("doGet");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

	
			/*Video v = new Video("AwsoXKP2HWE","El momo - sol de marzo");
			videosDao.insert(v);
			Video v2 = new Video("rC1KcJLRFDE","Shintoma - Somos de lo malo lo peor");
			videosDao.insert(v2);
			Video v3 = new Video("wWrXkBz74SU","Nach - Éxodo");
			videosDao.insert(v);
			res = true;*/
			
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
