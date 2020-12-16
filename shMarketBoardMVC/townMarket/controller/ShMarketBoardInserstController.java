package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.javachip.carrotcountry.common.MyFileRenamePolicy;
import com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.service.TownMarketService;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.Location;
import com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.PhotoBoardVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ShMarketBoardInserstController
 */
@WebServlet("/shBoardEnrollForm.sh.hy")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
				maxFileSize=1024*1024*50,      	// 50 MB
				maxRequestSize=1024*1024*100)      // 100 MB
public class ShMarketBoardInserstController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static final String UPLOAD_DIR = "filefolder";    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketBoardInserstController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  String savePath = request.getSession().getServletContext().getRealPath("/resources/images/shMarkt_upfiles/");
	  String photoPath = "resources/images/shMarkt_upfiles/";
	  String LoadPath = "resources/images/shMarkt_upfiles/";
	  Location l = null;
	  PostBoard pb = null;
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=UTF-8");
      
      String filePath = savePath + UPLOAD_DIR;
      File fileSaveDir = new File(savePath);		      
      if(!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();	
		}	
	  List<String> Flist = new ArrayList<String>(); //파일 이름을 담을 List
	  for(Part part : request.getParts()) {	   // 반복문들 돌면서 enctype 이 multipart 인 입력값을 part 객체에 저장. 
	if(part.getName().equals("file")) {			
		String renamed = new UploadRename().randomString(getFileName(part));
		part.write(savePath+File.separator+renamed);
		Flist.add(renamed);		
			}
	    }
	  
	//Flist 에는 지금 파일 이름이 담겨있음.
	ArrayList<PhotoBoardVo> pList = new ArrayList<>();
	  for(int i = 0; i<Flist.size(); i++) {    	  
		  PhotoBoardVo pbv = new PhotoBoardVo();
	      pbv.setPhotoPath(photoPath);
	      pbv.setPhotoFileName(Flist.get(i));
	      pbv.setPhotoLoadPath(photoPath);     
	      pList.add(pbv);       
	      } 
	 
	  String category1 = request.getParameter("category");
	 
         String category = request.getParameter("category");
         int memNo = Integer.parseInt(request.getParameter("memNo"));
         String memNick = request.getParameter("memNick");
         String postTitle = request.getParameter("title");
         String userText = request.getParameter("content");
         String pCondition = request.getParameter("p_condition");
         //==주소에 들어가야함
         String province = request.getParameter("province");
         String district = request.getParameter("district");
         String town = request.getParameter("town");
         //==주소 셋팅
         String dealType ="D";
         String site ="서울특별시";
         int price = Integer.parseInt(request.getParameter("price"));
         
         l = new Location(province,district,town);
         pb = new PostBoard(category,memNo,memNick,price,postTitle,userText,pCondition,dealType,site);
        // int result = new TownMarketService().shMarketBoardInsert(pb,Flist,l);     
       //  if(result>0) {        
      //      response.sendRedirect(request.getContextPath()+"/shMarketBoardMain.sh?currentPage=1");            
       
   	  int result = new TownMarketService().shMarketBoardInsert(pb,pList,l);
         
         if(result>0) {
            
            response.sendRedirect(request.getContextPath()+"/shMarketBoardMain.sh?currentPage=1");
            
         }            		
}
   //}
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }


   private String getFileName(Part part) {
       String contentDisp = part.getHeader("content-disposition");      
       String[] tokens = contentDisp.split(";");
       for (String token : tokens) {
           if (token.trim().startsWith("filename")) {     	
               return token.substring(token.indexOf("=") + 2, token.length()-1);
           }
       }
       return "";
   }


}