package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;

/**
 * Servlet implementation class ShMarketBoardReportAjaxController
 */
@WebServlet("/shMarketReport.sh.hy")
public class ShMarketBoardReportAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardReportAjaxController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		String rReason = request.getParameter("rReason");
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		String rContent = request.getParameter("rContent");		
		String alert="이미 신고한 게시글입니다.";
		String success="신고가 접수되었습니다.";
		String masaka="설마 이건가?";
		
		int precheck = new TownMarketService().reportPreCheck(memNo,postNo);
		
		if(precheck>0) {		
			out.print(alert);	
		} else {
			int result = new TownMarketService().shMarketReportInsert(memNo,rReason,postNo,rContent);
			
			if(result>0) {
				out.print(success);
			} else {
				out.print(masaka);
			}
			
			
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
