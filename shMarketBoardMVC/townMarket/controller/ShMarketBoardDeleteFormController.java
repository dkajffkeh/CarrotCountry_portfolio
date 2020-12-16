package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;

/**
 * Servlet implementation class ShMarketBoardDeleteFormController
 */
@WebServlet("/shMarketDeleteForm.sh")
public class ShMarketBoardDeleteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardDeleteFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		int result = new TownMarketService().townMarketDeleteForm(bno);
		
		if(result>0) {
			
			response.sendRedirect(request.getContextPath()+"/shMarketBoardMain.sh?currentPage=1");
			
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
