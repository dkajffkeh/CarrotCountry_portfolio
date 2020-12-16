package com.javachip.carrotcountry.shMarketBoard.mainPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.service.TownMarketIndexService;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;

/**
 * Servlet implementation class ShMarketMainBoardAjaxSelector
 */
@WebServlet("/mainIndexArticle.sh.hy")
public class ShMarketMainBoardAjaxSelector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketMainBoardAjaxSelector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8"); 
		ArrayList<PostBoard> pList = new TownMarketIndexService().shMarketBoardAjaxSelector();
		
		Gson gson = new Gson();
		gson.toJson(pList,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
