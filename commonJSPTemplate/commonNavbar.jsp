<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javachip.carrotcountry.member.model.vo.Member" %>
<%

Member loginMember = (Member)session.getAttribute("loginMember");
/* 	
	int memNo;			회원번호
	int localNo;		지역번호
	String memUserId;	회원아이디
	String memUserPwd;	회원비밀번호
	String memName;		회원명
	String memNickname;	회원닉네임
	String memBirthday;	생일(6자리)
	String memGender;	성별(남, 여)
	String memPhone;	전화번호()
	String memEmail;	이메일
	String profilePath	프로필 사진 경로
	String profileModifyname 	프로필 사진 수정명
	String profileOrignname 	프로필 사진 원본명
	String profileLoadname		경로 + 수정명?
	Date memEnrollDate;	회원가입일
	String bListCheck;	블랙리스트 유무(N, Y)
	String leaveCheck;	회원탈퇴 유무(N, Y)
	String managerCheck;관리자 유무(N, Y)
*/
String contextPath = request.getContextPath();

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Source+Sans+Pro:wght@200&display=swap" rel="stylesheet">  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/76c88d06f7.js"></script>
    <style>
    * {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
    box-sizing: border-box;
}
a {text-decoration: none;}
.navbar_Wrapper {
    background-color: orange;
    height: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    }
.navbar_sizeWraper_1200px {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1200px;
    height: 100%;
    }
.navbar_sizeWraper_1200px div {
    display: flex;
    justify-content: center;
	}
.user_info_display_sectionWrapper {
    margin-left: 50px;
	}
.user_info_display_sectionWrapper div {
    display: flex;
    align-items: center;
	}
.MainLogo_Wrapper {
    display: flex;
    align-items: center;
    }
.MainLogo_Wrapper>div i {font-size: 2rem;}
.menu_bar 				{margin-right: 50px;}
.menu_bar>table tr td a {color: white}
.user_inter_font 		{font-size: 0.7rem;}
.menu_bar table tr td   {padding-left: 10px;}
#LogoImg{
width:150px;
height:90px;
margin:0px;
position: relative;
top:10px;
left:40px;
}
        a {
            text-decoration: none
        }
        a:link {
            color: black;
            text-decoration: none;
        }
        a:visited {
            color: black;
            text-decoration: none;
        }
        a:hover {
            color: black;
            text-decoration: none;
        }
    </style>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar_Wrapper">
        <div class="navbar_sizeWraper_1200px">
            <div class="user_info_display_sectionWrapper" style="margin:0px;">
                <div><a href=""><i class="fas fa-user"></i></a></div>
                
                <% if(loginMember == null) { %>
                	<!-- 로그아웃 상태 -->
                	<div><a href="">비회원</a></div>
                <% }else { %>
                	<!-- 로그인 상태 -->
                	<div><a href=""><%= loginMember.getMemNickname() %></a></div>
                <% } %>
                
            </div>
            <div class=MainLogo_Wrapper style="position:relative; right:50px;">
                <div><a href="<%=contextPath%>"><img id="LogoImg" src="<%=contextPath%>/resources/images/commonImg/KakaoTalk_20201015_022259571_01.png" alt=""></a></div>
                <div><a href="<%=contextPath%>" style="font-size:2rem">당근나라</a></div>
            </div>
            <div class="menu_bar" style="margin:0px;">
                <table>
                    <tr align="center" class="user_inter_icon">
                    
                    	<% if(loginMember == null){ %>
	                    	<!-- 로그아웃 상태 -->
	                        <td><a href="<%= contextPath %>/loginPage.me.ng"><i class="fas fa-sign-in-alt"></i></a></td>
	                        <td><a href="<%= contextPath %>/enrollAgreePage.me.ng"><i class="far fa-plus-square"></i></a></td>
                        <% }else { %>
	                        <!-- 로그인 상태 -->
	                        <td><a href="<%= contextPath %>/logout.me.ng"><i class="fas fa-sign-out-alt"></i></a></td>
	                        <td><a href="<%= contextPath %>/myPage.me.jw?memNo=<%= loginMember.getMemNo() %>"><i class="fas fa-money-check"></i></a></td>
                        <% } %>
                    </tr>
                    <tr class="user_inter_font">
                    	<% if(loginMember == null){ %>
	                    	<!-- 로그아웃 상태 -->
	                        <td><a href="<%= contextPath %>/loginPage.me.ng">로그인</a></td>
	                        <td><a href="<%= contextPath %>/enrollAgreePage.me.ng">회원가입</a></td>
                        <% }else { %>
                        	<!-- 로그인 상태 -->
	                        <td><a href="<%= contextPath %>/logout.me.ng">로그아웃</a></td>
	                        <td><a href="<%= contextPath %>/myPage.me.jw?memNo=<%= loginMember.getMemNo() %>">마이페이지</a></td>
                        <% } %>
                    </tr>
                </table>        
            </div>
        </div>
    </nav>
</body>
</html>