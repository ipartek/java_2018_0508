package com.ipartek.formacion.controller.back;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.VideoDAO;
import com.ipartek.formacion.pojo.Video;

/**
 * Servlet implementation class BackofficeVideoController
 */
@WebServlet("/backoffice/videos")
public class BackofficeVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static VideoDAO daoVideo;
	
	String view = "";
	
	private static final String VIEW_FORM_VIDEOS = "videos/form.jsp";
	private static final String VIEW_INDEX_VIDEOS = "videos/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daoVideo = VideoDAO.getInstance();
		
		ArrayList<Video> videos = (ArrayList<Video>) daoVideo.getAll();
		
		String id = request.getParameter("id");
		
		try {
			if(id == null) {
				request.setAttribute("videos", videos);
				view = VIEW_INDEX_VIDEOS;
				
			}else {
				Video video = new Video();
				if(Integer.parseInt(id)>0) {
					video = daoVideo.getById(id);
				}
				view = VIEW_FORM_VIDEOS;
				request.setAttribute("video", video);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
