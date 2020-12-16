package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CommentHY;

/**
 * Servlet implementation class ShMarketBoardCommentController
 */
@WebServlet("/insertComment.sh")
public class ShMarketBoardCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardCommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String sContent = request.getParameter("cContent");
		String sCheck = request.getParameter("sCheck");
		String userNick = request.getParameter("userNick");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		int memNo = Integer.parseInt(request.getParameter("memNo"));

	
		
		CommentHY c = new CommentHY();
		c.setContent(sContent);
		c.setSecretCheck(sCheck);
		c.setUserNickName(userNick);
		c.setPostNo(postNo);
		c.setMemNo(memNo);
		
		
		
		CommentHY newc = new TownMarketService().shBoardInsertComment(c);
		response.setContentType("application/json; charset=utf-8"); 
		if(newc!=null) {
			
			Gson gson = new Gson();
			gson.toJson(newc,response.getWriter());
			
		} else {
			
			Gson gson = new Gson();
			gson.toJson("로드에 실패했습니다.",response.getWriter());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
