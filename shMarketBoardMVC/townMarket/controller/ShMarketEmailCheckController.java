package com.javachip.carrotcountry.shMarketBoard.townMarket.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.common.Gmail;
import com.javachip.carrotcountry.common.SHA256;

/**
 * Servlet implementation class ShMarketEmailCheckController
 */
@WebServlet("/emailCheck.sh")
public class ShMarketEmailCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShMarketEmailCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Properties p = new Properties();
		
		String hash = new SHA256().getSHA256(request.getParameter("userEmail"));
		String host = "http://localhost:8888/carrot";
		String from = "dkajffkem@gmail.com";
		String content = "당근나라 회원인증 메세지 입니다.";
		
		p.put("mail.smtp.user","구글 이메일계정");
		p.put("mail.smtp.host","smtp.googlemail.com");
		p.put("mail.smtp.port","465");
		p.put("mail.smtp.starttls","true");
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.debug","true");
		p.put("mail.smtp.socketFactory.port","465");
		p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback","false");
		
		try {
			
			Authenticator auth = new Gmail();
			Session session = Session.getInstance(p,auth);
			session.setDebug(true);
			
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject("테스트");
			
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			
			Address toAddr = new InternetAddress(request.getParameter("userEmail"));
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			
			msg.setContent(content,"text/html;charset=UTF-8");
			
			Transport.send(msg);
			
			
		} catch(Exception e) {
			e.printStackTrace();			
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
