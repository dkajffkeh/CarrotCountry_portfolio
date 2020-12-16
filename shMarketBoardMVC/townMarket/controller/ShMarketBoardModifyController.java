package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.PhotoBoardVo;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ShMarketBoardModifyController
 */
@WebServlet("/shBoardModifyForm.sh.hy")
public class ShMarketBoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 15*1024*1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/images/shMarkt_upfiles/");
			
			MultipartRequest mr = new MultipartRequest(request,savePath,maxSize,"utf-8",new MyFileRenamePolicy());
			//=====보드객체 update=====
			int bno = Integer.parseInt(mr.getParameter("bno"));
			String category = mr.getParameter("category"); //String 번호값으로 담겨있음.
			String title = mr.getParameter("title");		
			String content = mr.getParameter("content");
			int price = Integer.parseInt(mr.getParameter("price")); //보드객체에도 들어가고 USEDPROD 에도 들어감.
			Location l = new Location(mr.getParameter("province"),mr.getParameter("district"),mr.getParameter("town")); //주소객체에 들어감.	
			String pCondition = mr.getParameter("p_condition"); //USEDPROD 에 들어감.
			
			PostBoard b = new PostBoard(bno,category,title,content,price);
			//USEDPROD 에 들어감			
			
			if(mr.getOriginalFileName("pictures1")==null) {
				//Board 랑 Usedprod 만 업데이트 하면됨.
				//사진이 포함되지 않은 자료를 없데이트
				
				int result = new TownMarketService().shMarketBoardModify(b,l,pCondition);
				response.sendRedirect(request.getContextPath()+"/townMarketBoardDetail.sh?bno="+bno);
				
			} else if(mr.getOriginalFileName("pictures1")!=null) {
				//PhotoBoard 에 변경하상이 있음
				
				ArrayList<PhotoBoardVo> pList = new ArrayList(); //일단 여기에 사진 담음.
				//for 문을 이용해서 사진 정보를 담음.
				for(int i = 0 ; i<=4 ; i++) {
					
					String key = "pictures"+i;
					
					if(mr.getOriginalFileName(key)!=null) {
						
						PhotoBoardVo pv = new PhotoBoardVo();
						pv.setPhotoPath("resources/images/shMarkt_upfiles/");
						pv.setPhotoFileName(mr.getFilesystemName(key));
						pv.setPhotoLoadPath("resources/images/shMarkt_upfiles/");						
						pList.add(pv);
					}
					
				}
				//사진까지 포함된 자료를 update
				int result = new TownMarketService().shMarketBoardModifyPlusPhoto(b,l,pCondition,pList);
				
				if(result>0) {
					response.sendRedirect(request.getContextPath()+"/townMarketBoardDetail.sh?bno="+bno);
				}
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
