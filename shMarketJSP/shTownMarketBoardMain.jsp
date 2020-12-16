<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY" %>
<%@ page import="com.javachip.carrotcountry.shMarketBoard.mainPage.model.vo.PostBoard" %> 
<%@ page import="com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.ShmarketPageInfo" %> 
<%
ArrayList<CategoryHY> list = (ArrayList)request.getAttribute("list");
//카테고리 이름
//게시글 번호, 맴버번호 , 지역정보, 글제목, 카테고리 , 카테고리 이름,썸네일 경로 파일이름,파일명, views , like , 가격  
ShmarketPageInfo sp = (ShmarketPageInfo)request.getAttribute("sp");
/*
		currentPage	//현재페이지				
		listCount;  //게시글 총 갯수.
		boardLimit; //한페이지에 몇개 보여줄건지
		pageLimit;  //페이지 하단에 보여질 페이지 갯수
		maxPage;    //마지막페이지
		startPage;  //첫 페이지
		endPage;    //마지막 페이지
*/
ArrayList<Integer> likeCount = (ArrayList)request.getAttribute("likeCount");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style type="text/css">
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
            cursor:pointer;
        }
        html {
    position: relative;
    min-height: 100%;
    margin: 0;
}
* {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
    box-sizing: border-box;
}
div,p,a,h2,h1{
font-family: 'Jua';
}  
body {min-height: 100%;}
img {height:100%; width:100%; border-radius: 5px;}
/*   <!-- ===============================최 상단 bar  ======================= -->       */
.navbar_Wrapper {
    background-color: orange;
    height: 70px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-bottom:1px solid green;
    font-size: 1.5rem;
}
.navbar_sizeWraper_1200px {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 1200px;
    height: 100%;
}
.banner_cursor_wrapper div i {font-size: 30px;}
.navbar_sizeWraper_1200px div {
    display: flex;
    justify-content: center;
}
.user_info_display_sectionWrapper {margin-left: 50px;}
.user_info_display_sectionWrapper div {
    display: flex;
    align-items: center;
}
.MainLogo_Wrapper {
    display: flex;
    align-items: center;
}
.MainLogo_Wrapper>div i {font-size: 2rem;}
.menu_bar {margin-right: 50px;}
.menu_bar>table tr td a {color: white}
.user_inter_font {font-size: 0.7rem;}
.menu_bar table tr td {padding-left: 10px; margin-left: 50px}
/* <!-- 검색 구간 --> */
.section_contatiner{
    width: 1200px;
    display: flex;
    justify-content: center;
    margin:auto;
}
.form-control:hover {border:1px solid black;}
.wrn-btn{
    width:100px;
    font-size: 16px;
    font-weight: 400;
    border-radius:0;
}
/* <!-- 검색 구간 --> */
/* <!-- 정렬 구현 구간 --> */
#sorter_wrapper {
    margin: auto;
    width:1200px;
    padding: 0;
    display: flex;
    justify-content: flex-end;
}
.sorter_row {
    display: flex;
    width:300px;
}
.sorter_row > p {
    color:orange;
    padding-left: 5px;
    margin-top: 35px;
    margin-bottom: 0;
    cursor: pointer;
}

.sorter_row > p:hover{
color:green;
}
/* 메인 아티클 CSS */
/*사이트바*/
 #mainArticle_wrapper {
     width:1200px;
     height:1250px;    
     margin:auto;
     margin-top: 20px;   
     display: flex;
     justify-content: center;
 }
 .mainArticle_sidebar {
     height:42.5%;
     width:200px;
     
     background-color: rgb(255, 213, 122);
 }
 .side_bar.font {
     width:100%;
     height:5%;
     font-size: 1.5rem;
     text-align: center;
     border-bottom:2px solid rgb(226, 226, 226);
     cursor:pointer;
 }
 .side_bar.font:hover {
  background-color:lightgreen;
 }
 /*사이트바*/
 /*오른쪽 아티클 구간*/
 .location_display {
     width:200px;
     margin: auto;
     font-size: 1.5rem;
    
 }
 .mainArticle_article {
     height:100%;
     width:1000px;
     padding-left: 25px;
 }
 .article_frame {
     display: inline-block;
     margin-right: 15px;
     margin-bottom: 15px;
     height:300px;
     width:23%;
     cursor:pointer;  
 }
 .article_frame:hover {
 border:1px solid lightgrey;
 border-radius:10px;
 }
 .borderNo {display:none;}
 .img_frame {
     height:60%;
     width:100%;
 }
 .product_title {
    margin-top: 5px;
    width:100%;
    height:10%;
}
.popular_board_title {
   text-decoration: none;
   margin-left:10px;
   font-weight: bold;
}
.location_area {
    height:7%;
    width:96.5%;
    margin-left: 10px;  
}
.ratring_counter {   
    width:100%;
    height:6%;
    display: flex;
    float: left;
}
.ratring_counter > p {
    font-size: 0.7rem;
    height:100%;
    margin-left: 10px;
    margin-top:10px;
    color:grey;
}
.price_display {
    height:18%;
    text-align: right;
    line-height: 250%;
    margin-right: 10px;;
    font-size: 1.5rem;
    font-weight: bold;
    color:orange;
}
.bottom_font {
    width:200px;
    height:20px;
    margin:auto;
    margin-top: 15px;
    font-size: 1rem;
    font-weight: bold;
}
.page_display {
    width:1200px;
    height:40px;
    
    margin: auto;
    display: flex;
    justify-content: space-between;
}
/*오른쪽 아티클 구간*/
/* 메인 아티클 CSS */
#footerbar {
    position: absolute;
    top: 100%;
    width: 100%;
    height: 270px;
    background-color: #00251a
}
.footerbar_totalWrapper {
    width: 1200px;
    height: 100%;
    border: 1px solid white;
    margin: auto;
}
.footer_upperWrapper {
    width: 100%;
    height: 52px;
    border: 1px solid white;
    display: flex;
    justify-content: center;
    align-items: center;
}
.footer_upperWrapper>button {
    margin-left: 40px;
}
.footer_belowWrapper {
    height: 200px;
    display: flex;
    justify-content: center;
    align-items: center;
}
    </style>
</head>
<body>
<%@ include file="../common/commonNavbar.jsp"%>

<!-- 제목 -->
    <h1 align="center" style="margin-top: 25px; font-weight: bold;">우리동네 마켓</h1>
    <hr style="border-bottom: 2px solid grey;">

    <!-- 검색 구간 -->
    <section class="search-sec">
        <div class="container">
            <form action="#" method="post" novalidate="novalidate">
				
                <div class="col-lg-12">
                    <div class="row">
                        <div class="section_contatiner">
                            <input type="text" name="userSearch" class="form-control search-slt" placeholder="제목 또는 제품명을 검색해주세요"
                                style="width: 400px; margin-right: 6px;">

                            <select class="form-control search-slt" name="district" style="width:150px; margin-right: 6px;">
                                  <option value="송파구" selected>송파구</option>
                    			  <option value="강서구">강서구</option>                       
                            </select>
                            <select class="form-control search-slt" name="town" style="width:150px; margin-right: 6px;">
                                <option value="오금동">오금동</option>
			                    <option value="오류동">오류동</option>
			                    <option value="상일동">상일동</option>
                            </select>
                            <select class="form-control search-slt" name="prodCategory" style="width:150px; margin-right: 6px;">
                                <% for(int i = 0; i<list.size(); i++){ %>
                                <option value="<%=list.get(i).getCategoryName()%>"><%=list.get(i).getCategoryName()%></option>
                                <% } %>
                            </select>                     
                            <button type="button" class="btn btn-warning wrn-btn" onclick="userSearchAjax();"><i class="fas fa-carrot"></i></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <script>
    $(function(){    	
    	$("select[name=district]").click(function(){  		
    		let str="";
    	 if($("select[name=district] option:selected").val()=="강서구"){
    		 
    		 str+=   `<option value="화곡동">화곡동</option>
                 	  <option value="목동">목동</option>`;
		
	   		$("select[name=town]").html(str);				    		 
    	 } else {  		 
    		 str+=   `<option value="오금동">오금동</option>
	                  <option value="오류동">오류동</option>
	                  <option value="상일동">상일동</option>`;		
  		$("select[name=town]").html(str);
    		 
    	 }	
    	})  	
    })
    </script>

    <!-- 검색 구간 -->

    <!-- 정렬 구현 구간 -->
    <div id="sorter_wrapper">
        <div class="sorter_row">
            <p onclick="articleSorter(1)">최신순 </p>
            <p onclick="articleSorter(2)">낮은가격 </p>
            <p onclick="articleSorter(3)">인기상품 </p>
            <p onclick="articleSorter(4)">조회수</p>
        </div>
    </div>

    <hr style="border-bottom: 2px solid grey; margin-top: 2px;">
    <!-- 정렬 구현 구간 -->

    <!-- main 아티클 구간 -->

	<div class="location_display"></div>
	
	
	
    <div id="mainArticle_wrapper">
        <div class="mainArticle_sidebar">
            <div>
            <% for(int i = 0 ; i<list.size(); i++) { %>
                <div class="side_bar font" style="cursor:pointer" onclick="categoryAjax(this);"><%= list.get(i).getCategoryName() %></div>
              <% } %>
            </div>      
        </div>
        <div class="mainArticle_article">
  
        </div>
     </div>
     <div class="page_display" style="margin-bottom:25px; margin-top: 10px;">
        <div style="width:100px"><!-- 간격 유지용 div --></div>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
            

             
            </ul>
          </nav>         
          <button type="button" class="btn btn-warning" id="postEnroll_btn">게시글 올리기</button>
     </div>
     <script>
     let enrollBtn = document.getElementById("postEnroll_btn");
     
     enrollBtn.addEventListener('click',goToEnroll)
     
     function goToEnroll(){
		<%if(loginMember!=null) {%>	 
    	 location.href="<%=contextPath%>/shPostBoardEnroll.sh"; 
    	 <% } else {%>
    	 
    	 if(confirm("게시글은 회원분만 이용이 가능합니다 로그인 페이지로 이동하시겠습니까?")){
    		 location.href="<%=contextPath%>/loginPage.me.ng";
    	 }	 
    	 <%}%>
     }  
     </script>   
<%@ include file="../common/footerbar.jsp"%>

<script>
$(function(){
	
	mainArticleAjaxFunc();

 function mainArticleAjaxFunc(){	
 
	$.ajax({
		url:"townMarketBoardSelectAjax.sh.hy",
		type:"post",
		data:{currentPage:1},
		success:function(list){
			console.log(list)
			ArticleSelector(list);	
		
			PagingSort(list);        
		
		},
		error:function(){
			console.log("실패");
		}	
	})		
 }
 
})
//ajax 페이징 처리 ajax
function ajaxSelector(num){
	
	let $articleOuter = $(".mainArticle_article");	
	$.ajax({
		url:"townMarketBoardSelectAjax.sh.hy",
		type:"post",
		data:{currentPage:num},
		success:function(list){
				
			ArticleSelector(list);
			
			PagingSort(list);
	
		}
	});
	
}
//카테고리 버튼 누르면  불러오는 ajax
function categoryAjax(tar){
	
	let categoryName = tar.innerHTML;
	
	$.ajax({
		url:"townMarketBoardCategoryAjax.sh.hy",
		type:"post",
		data:{currentPage:1,
			  cName:categoryName},
		success:function(list){
			
			ArticleSelector(list)
						
			$("ul[class=pagination]").html('');
		},		
	})
	
}
//검색기능 ajax
function userSearchAjax(){
	
	let userGu = $("select[name=district]").val();
	let userDo = $("select[name=town]").val();
	let userInput =	$("input[name=userSearch]").val();
	let prodCategory = $("select[name=prodCategory]").val();
	
	$.ajax({
		url:"shMarketUserSearch.sh.hy",
		type:"get",
		data:{
			currentPage:1,
			userSearch:userInput,
			userGu:userGu,
			userDo:userDo,
			category:prodCategory
		},
		success:function(list){
			ArticleSelector(list)
			$("input[name=userSearch]").val('');
			$("ul[class=pagination]").html('');		
			$(".location_display").html(userGu+" "+userDo);			
		},
		error:function(){
			
		}
	})
		
}
//정렬 ajax
function articleSorter(num){
	
	let sortNo = num;	
	$.ajax({
		url:"postSort.sh.hy",
		type:"post",
		data:{
			sortNo:num,
		 currentPage:1		
		},
		success:function(list){
			ArticleSelector(list);			
			numberSortPage(list,num);	
		},
		error:function(){			
		}		
	})	
}

//정렬ajax페이지 구현 함수
function articleSorterPaging(Cnum,num){
	
	let sortNo = num;
    
	$.ajax({
		url:"postSort.sh.hy",
		type:"post",
		data:{
			sortNo:num,
		 currentPage:Cnum		
		},
		success:function(list){
			
			ArticleSelector(list);
				
			numberSortPage(list,num)
			
		},
		error:function(){
			
		}	
	
	})	
}


function ArticleSelector(list){
	
	let $articleOuter = $(".mainArticle_article");
	let str = "";
	
	for(let i = 0; i<list.length ; i++){			
	
		str += `<div class="article_frame" onclick=detailfunc(this)>
            	<div class="borderNo">\${list[i].postNo}</div>
                <div class="img_frame"><img   src="<%=contextPath%>/\${list[i].thumbnailLoadPath+list[i].thumbnailFilename}" alt=""></div>
                <div class="product_title">
                    <h6 class="popular_board_title">\${list[i].postName}</h6>
                </div>
                <div class="location_area">\${list[i].localNo}</div>
                <div class="ratring_counter">
                    <p>\${"조회수:" + list[i].postViews + " 찜:" + list[i].postLikes}</p>
                </div>
                <div class="price_display">\${list[i].prodPrice}</div>
            </div>`;				
	}		
	$articleOuter.html(str);	
}


function numberSortPage(list,num){
	
	let pagingNodes = "";
	let backBtn   ="";
	let pagingNum = "";
	let nextBtn   ="";
	let result = "";
	if(list[0].currentPage!=1){
	backBtn += `<li class="page-item" onclick=articleSorterPaging(\${list[0].currentPage-1},\${num})>
        <a class="page-link" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>         
      </li>`};       
    
    for(let j = list[0].startPage ; j<=list[0].endPage ; j++){
    pagingNum +=`<li class="page-item"><a class="page-link" onclick=articleSorterPaging(\${j},\${num})>\${j}</a></li>`
    };
           
    if(list[0].currentPage!=list[0].maxPage){
    nextBtn += `<li class="page-item" onclick=articleSorterPaging(\${list[0].currentPage+1},\${num})>
        <a class="page-link" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>`};
      result = backBtn + pagingNum + nextBtn;

      $("ul[class=pagination]").html(result);
	
}
//초기화면 list
function PagingSort(list){
	
	let pagingNodes = "";
	let backBtn   ="";
	let pagingNum = "";
	let nextBtn   ="";
	let result = "";
	if(list[0].currentPage!=1){
	backBtn += `<li class="page-item" onclick=ajaxSelector(\${list[0].currentPage-1})>
        <a class="page-link" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>         
      </li>`};       
    
    for(let j = list[0].startPage ; j<=list[0].endPage ; j++){
    pagingNum +=`<li class="page-item"><a class="page-link" onclick=ajaxSelector(\${j})>\${j}</a></li>`
    };
           
    if(list[0].currentPage!=list[0].maxPage){
    nextBtn += `<li class="page-item" onclick=ajaxSelector(\${list[0].currentPage+1})>
        <a class="page-link" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>`};
      result = backBtn + pagingNum + nextBtn;

      $("ul[class=pagination]").html(result);
}

function detailfunc(t){
	
   let bno = t.childNodes[1].innerHTML;
   location.href="<%=contextPath%>/townMarketBoardDetail.sh?bno="+bno;

}

</script>

</body>
</html>