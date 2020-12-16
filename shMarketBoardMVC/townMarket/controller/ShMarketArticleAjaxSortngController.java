package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo;

/**
 * Servlet implementation class ShMarketArticleAjaxSortngController
 */
@WebServlet("/postSort.sh.hy")
public class ShMarketArticleAjaxSortngController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketArticleAjaxSortngController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/json; charset=utf-8");
		
		int sortNum = Integer.parseInt(request.getParameter("sortNo"));

		int currentPage;
		int listCount; //게시글 총 갯수.
		int boardLimit;//한페이지에 몇개 보여줄건지
		int pageLimit; //페이지 하단에 보여질 페이지 갯수
		int maxPage; //마지막페이지
		int startPage; // 첫 페이지
		int endPage; // 마지막 페이지
		
		listCount = new TownMarketService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		boardLimit = 16;
		pageLimit=5;
		maxPage = (int)Math.ceil(((double)listCount/boardLimit));
		
		startPage =((currentPage-1)/pageLimit)*pageLimit+1; 
		
		endPage = startPage + pageLimit-1;
		
		if(endPage>maxPage) {
			endPage = maxPage;
		}
		
		ShmarketPageInfo sp = new ShmarketPageInfo(currentPage
                ,listCount
                ,boardLimit
                ,pageLimit
                ,maxPage
                ,startPage
                ,endPage);
		
		ArrayList<PostBoard> pb = new TownMarketService().shMarketArticleAjaxSortng(sp,sortNum);
		
		Gson gson = new Gson();
		gson.toJson(pb,response.getWriter());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
