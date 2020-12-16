<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/common/mainMenu.css">
    <title>CarrotCountry</title>
    <style>
div,p,a,h2{
font-family: 'Jua';
}    
#top8_board_wrapper {
    width:1200px;
    height:750px;
    margin:auto;
    margin-top: 15px;
    margin-bottom: 15px;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
}

#top8_board_wrapper > .product_display_wrapper{
    width:23%;
    height:50%;
    float: left;
    box-sizing: border-box; 
}
.product_display_wrapper:hover{
border:1px solid lightgray;
cursor:pointer;
}
.d-block.w-100{cursor:pointer;}
.d-block.w-100:hover{border:1px solid orange;}
.product_display_wrapper > div {margin-bottom: 5px;}
.hiddenBoardNum {display:none;}
    </style>
</head>
<body>
  <%@ include file="views/common/commonNavbar.jsp" %>
  
   <!-- =============================== 인기 게시물 썸내일 사진 display  ======================= -->
    <div class="banner_Wrapper">
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">   
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div id="carouselExampleControls1" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">  
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls1" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls1" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
    </div>
    <!-- <i class="fas fa-ellipsis-h"></i> -->
    <!-- =============================== 인기 게시물 썸내일 사진 display  ======================= -->
    
    <!-- =============================== 중고게시판 공동구매 게시판 버튼  ======================= -->
    <div class="board_button_wrapper">
    <button type="button" class="btn btn-outline-warning" id="townMarket_button">동네마켓</button>
    
   
    <script>
    
    let town_btn0 = document.getElementById("townMarket_button");
    
    town_btn0.addEventListener('click',toTown);
  
    function toTown(){
    	 	
        location.href="<%=contextPath%>/shMarketBoardMain.sh?currentPage=1";
		
    }
    </script>
    <button type="button" class="btn btn-outline-success" id="coBuying_button">공구마켓</button>
    
       
    <script>  
    let coBuying_btn0 = document.getElementById("coBuying_button");
    
    coBuying_btn0.addEventListener('click',toCoBuying);
  
    function toCoBuying(){
 
        location.href="<%=contextPath%>/mainpage.co.jy?currentPage=1";	
    }
    </script>
    </div>

    <!-- =============================== 중고게시판 공동구매 게시판 버튼  ======================= -->
    <hr>
    <h2 align="center" style="margin-top: 15px; font-weight: bold;">인기 매물</h2>

    <!-- =============================== 인기 게시글 섹션  ======================= -->
      <div id="top8_board_wrapper">
            <div class="product_display_wrapper"
                 style="width:23%;
                        height:50%;
                        float: left;">
             <div class="img_wraper"      
             style="width:100%; 
             height:60%;">
             <div class="hiddenBoardNum">1</div> 
             <img src="" alt="" style="border-radius: 5px;" >
            </div>
             <div class="product_title"
                  style="font-size: 1.3rem;">XXX</div>
             <div class="location_area">XXX XXX</div>
             <div class="ratring_counter">
                 <p style="font-size: small; color:darkgray">조회수:xx 찜:xx</p>
             </div>
             <div class="price_display" style="float:right; color:orange; font-size: 1.5rem;">30000</div>
            </div>
    </div>
        <div  align="center"><a class="bottom_font" style="cursor:pointer;" id="townMarket_button1">매물 더 보기</a></div>
        
        
        <script>
        let town_btn1 = document.getElementById("townMarket_button1");
        town_btn1.addEventListener('click',toTown1);
     
        function toTown1(){
  
            location.href="<%=contextPath%>/shMarketBoardMain.sh?currentPage=1";
        }
        </script>
     

  <%@ include file="views/common/footerbar.jsp" %>
    
  <script>
  $(function(){
	  
	  mainIndexArticleSelector();
	  
	  window.setInterval(mainIndexArticleSelector,1000*60*5);
	  	  
	function mainIndexArticleSelector(){
		
		$.ajax({
			url:"mainIndexArticle.sh.hy",
			type:"post",
			success:function(list){
				console.log(list);
				let $top8Board = $("#top8_board_wrapper");
				let str = "";
				
				//하단 메인 아티클 부분 보여줄곳.
				if(list.length==0){
					
					str +=` <div class="emptyMsgOuter" 
				           style="width:100%; 
		                  height:100%; 
		                  border:1px solid red;
		                  display: flex;
		                  justify-content: center;
		                  align-items: center;">
			             <div class="emptyMagText" style="font-size: xx-large;">
			            표시할 게시물이 없습니다.
			            </div>
			            </div> `
				} else {
					for(let i = 0 ; i<list.length ; i++){
						
						str+= `<div class="product_display_wrapper"
							 onclick="toBoardDetail(this);"
			                 style="width:23%;
	                        height:50%;
				            float: left;">
				            <div class="hiddenBoardNum">\${list[i].postNo}</div>
				             <div class="img_wraper"      
				             style="width:100%; 
				             height:60%;">			              
				             <img src="<%=contextPath%>/\${list[i].thumbnailLoadPath+list[i].thumbnailFilename}" alt="" style="border-radius: 5px;" >
				            </div>
				             <div class="product_title"
				                  style="font-size: 1.3rem;">\${list[i].postName}</div>
				             <div class="location_area">\${list[i].localNo}</div>
				             <div class="ratring_counter">
				                 <p style="font-size: small; color:darkgray;">조회수:\${list[i].postViews} 찜:\${list[i].postLikes}</p>
				             </div>
				             <div class="price_display" style="float:right; color:orange; font-size: 1.5rem;">\${list[i].prodPrice}</div>
				            </div>`					
					}
					
					$top8Board.html(str);
					
				}
			//사진 카로우저 보여줄 파트 오른쪽
			let pstr  = "";
			let pstr1 ="";
			let cc = $("#carouselExampleControls > .carousel-inner");
			let cc1 = $("#carouselExampleControls1 > .carousel-inner");
			
			if(list.length==0){
				
			  pstr+= `<div 
		              class="emptyMsgOuter"
		              style="width:100%;   
		              height:100%; 
		              border:1px solid red;
		              display: flex;
		              justify-content: center;
		              align-items: center;">	              
		                <div class="emptyMagText" style="font-size: xx-large;">
		                	  표시할 게시물이 없습니다.
		                </div>     	  
		              </div>`
			
			} else if(list.length<4){
				
				pstr+=`<div class="carousel-item active" onclick="toBoardDetailFromPic(this)">
					<div class="hiddenBoardNum">\${list[0].postNo}</div>
               		  <img class="d-block w-100" src="<%=contextPath%>/\${list[0].thumbnailLoadPath+list[0].thumbnailFilename}">
                      </div>`
				
                for(let j =1; j<list.length ; j++){
                	
                	pstr+=`<div class="carousel-item" onclick="toBoardDetailFromPic(this)">
                		<div class="hiddenBoardNum">\${list[j].postNo}</div>
	                        <img class="d-block w-100" src="<%=contextPath%>/\${list[j].thumbnailLoadPath+list[j].thumbnailFilename}">
	                       </div>`   	
                }
				
				
			} else if(list.length>4){
				
				pstr+=`<div class="carousel-item active" onclick="toBoardDetailFromPic(this)">
					<div class="hiddenBoardNum">\${list[0].postNo}</div>
             		  <img class="d-block w-100" src="<%=contextPath%>/\${list[0].thumbnailLoadPath+list[0].thumbnailFilename}">
                    </div>`
				
              for(let j =1; j<4; j++){
              	
              	pstr+=`<div class="carousel-item" onclick="toBoardDetailFromPic(this)">
              		<div class="hiddenBoardNum">\${list[j].postNo}</div>
	                        <img class="d-block w-100" src="<%=contextPath%>/\${list[j].thumbnailLoadPath+list[j].thumbnailFilename}">
	                       </div>`   	
              
              }
							
			}			
			cc.html(pstr);
			
			if(list.length<4){
				
				pstr1 +=  `<div 
		              class="emptyMsgOuter"
		              style="width:100%;   
		              height:100%; 
		              border:1px solid red;
		              display: flex;
		              justify-content: center;
		              align-items: center;">	              
		                <div class="emptyMagText" style="font-size: xx-large;">
		                	  표시할 게시물이 없습니다.
		                </div>     	  
		              </div>`
         	} else if(list.length<8){
         		
         		pstr1 +=`<div class="carousel-item active" onclick="toBoardDetailFromPic(this)">
         			<div class="hiddenBoardNum">\${list[4].postNo}</div>
             		  <img class="d-block w-100" src="<%=contextPath%>/\${list[4].thumbnailLoadPath+list[4].thumbnailFilename}">
                    </div>`
         		for(let i = 5 ; i<list.length ; i++){
         			
         			pstr1 +=`<div class="carousel-item" onclick="toBoardDetailFromPic(this)">
         				<div class="hiddenBoardNum">\${list[i].postNo}</div>
                        <img class="d-block w-100" src="<%=contextPath%>/\${list[i].thumbnailLoadPath+list[i].thumbnailFilename}">
                       </div>` 
         			
         		}
         		
         	} else if(list.length==8){
         		
         		pstr1 +=`<div class="carousel-item active" onclick="toBoardDetailFromPic(this)">
         			<div class="hiddenBoardNum">\${list[4].postNo}</div>
           		  <img class="d-block w-100" src="<%=contextPath%>/\${list[4].thumbnailLoadPath+list[4].thumbnailFilename}">
                  </div>`
       		for(let i = 5 ; i<8 ; i++){
       			
       			pstr1 +=`<div class="carousel-item" onclick="toBoardDetailFromPic(this)">
       				<div class="hiddenBoardNum">\${list[i].postNo}</div>
                      <img class="d-block w-100" src="<%=contextPath%>/\${list[i].thumbnailLoadPath+list[i].thumbnailFilename}">
                     </div>` 
       			
       		}
         		
         	}
			
			cc1.html(pstr1)
			
			},
			error:function(){
				
			}
				
		});	
	}
	  
  })
  
function toBoardDetail(t){
	  
	  let bno = t.childNodes[1].innerHTML;
	  location.href="<%=contextPath%>/townMarketBoardDetail.sh?bno="+bno;
 
  }
  
function toBoardDetailFromPic(t){
	
	let bno = t.childNodes[1].innerHTML;
	location.href="<%=contextPath%>/townMarketBoardDetail.sh?bno="+bno;
}


  </script>
</body>
</html>