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
 * Servlet implementation class shMarketCommentReportAjaxFormController
 */
@WebServlet("/shMarketCommentReport.sh.hy")
public class shMarketCommentReportAjaxFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shMarketCommentReportAjaxFormController() {
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
		
		int precheck = new TownMarketService().shMarketCommentReportPrecheck(memNo,postNo);
		
		
		if(precheck>0) {
			
			out.print("이미 신고접수가 완료되었습니다.");
			
		}else {
			
			int result = new TownMarketService().shMarketCommentReportInsert(memNo,rReason,postNo,rContent);
			
			if(result>0) {
				out.print("신고접수가 완료되었습니다");
			} else {
				out.print("알수없는 오류로 신고접수가 취소되었습니다.");
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
