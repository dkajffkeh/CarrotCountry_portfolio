<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.javachip.carrotcountry.shMarketBoard.townMarket.model.vo.CategoryHY" %>
<%@ page import="javax.mail.*" %>
<%@ page import ="com.javachip.carrotcountry.common.Gmail" %>
<%@ page import ="com.javachip.carrotcountry.common.SHA256" %>
<%@ page import ="java.util.Properties" %>
<!DOCTYPE html>
<%
ArrayList<CategoryHY> list = (ArrayList)request.getAttribute("list");
Properties p = new Properties();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
<style>
  a 		{text-decoration: none}
  a:link 	{color: black;
         	 text-decoration: none;}
  a:visited {
            color: black;
            text-decoration: none;}
  a:hover   {
            color: black;
            text-decoration: none;}
body {min-height: 100%;}
div,p,a,h2,h1{
font-family: 'Jua';
}  
#page_total_wrapper {
    width:850px;
    height:100%;
    border:1px solid rgb(252, 255, 72);
    border-radius: 15px;
    padding-left: 15px;
    padding-top:15px;
    margin:auto;
    margin-top:20px;
    margin-bottom:20px;
    box-shadow: 3px 3px 2px 2px rgb(255, 189, 35);
}
input[name="Title"] {
    width:500px;
}
input[name="price"]{
    width:250px;
}
input[name="Title"]:hover {
    box-shadow: 0.5px 0.5px 2px 2px rgb(216, 216, 216);
}
select[class="form-control"] {
    width:150px;
    margin-right: 10px;
}
#form1>h5{
    margin-bottom: 10px;
    margin-top: 20px;
    font-weight: bold;
}
input[type="radio"]{
    margin-right: 6px;
}
#preview_frame {
    width:99%;
    height:200px;
    background-color: lightgray;
    display: flex;
    border-radius: 10px;
    padding:0px 5px 0px 10px;
    
}
#preview_frame>div{
    width:23%;
    height:100%;
    margin-right: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 10px;
    cursor: pointer;
    border:2px solid orange;   
}
#preview_frame>.image_wrapper:hover{
border:2px solid green;
}

.image_wrapper>img {
    width:100%;
    height:100%;
    border-radius: 10px;
   
}
.submit_button_wrapper {
    width:96.5%;
    display: flex;
    justify-content: space-between;
}
.image_wrapper>i {
    position: relative;
    font-size: 1.5rem;
    right:32px;
    top:70px;
    cursor: pointer;
    color:white;
}
</style>
</head>
<body>
<%@ include file="../common/commonNavbar.jsp"%>

<% String userId = loginMember.getMemUserId();  
   String to = loginMember.getMemEmail();
   
%>



<div id="page_total_wrapper">
        <form action="shBoardEnrollForm.sh.hy" id="form1" enctype="multipart/form-data" method="post">
        <input type="hidden" name="memNo"   value="<%=loginMember.getMemNo()%>">
        <input type="hidden" name="memNick" value="<%=loginMember.getMemNickname()%>">
            <h5>물품등록</h5>
            <hr>
            <div class="product_info_input" style="display: flex;">
                <input type="text" name="title" class="form-control" placeholder="상품명을 입력해주세요"
                    style="margin-right: 5px;">
                <select name="category" id="" class="form-control" style="color:gray;">
                   		<% for(int i =0 ; i<list.size(); i++){ %>
						<option value="<%=10+10*i%>"><%=list.get(i).getCategoryName() %></option>
						<% } %>
                </select>
            </div>
            <h5>가격입력</h5>
            <div class="price_info_input" style="display: flex;">
                <input type="text" class="form-control" name="price" placeholder="가격을 넣어주세요" required style="margin-right: 10px;">
                <h4 style="line-height: 180%;">원</h4>
            </div>
            <h5>상품상태</h5>
            <div class="product_condition_radio">
                <input type="radio" name="p_condition" value="미개봉" id="Pradio_1" checked>
                <label for="Pradio_1">미개봉</label>
                <input type="radio" name="p_condition" value="거의 새것" id="Pradio_2">
                <label for="Pradio_2">거의 새것</label>
                <input type="radio" name="p_condition" value="사용감" id="Pradio_3"> 
                <label for="Pradio_3">사용감
                    있음</label>
            </div>
            <h5>주소입력</h5>
            <div class="location_input" style="display: flex;">
                <select id="province" name="province" class="form-control">
                    <option value="서울특별시">서울특별시</option>
                </select>
                <select id="district" name="district" class="form-control">
                    <option value="송파구">송파구</option>
                    <option value="강서구">강서구</option>
                </select>
                <select id="town" name="town" class="form-control">
                    <option value="오금동">오금동</option>
                    <option value="오류동">오류동</option>
                    <option value="상일동">상일동</option>
                </select>
            </div>
               <script>
            //option테그 주소선택 js
            $(function(){
            	
					$("#district").click(function(){
						let str="";
						if($("#district option:selected").val()=="강서구")
						{
							str+=   `<option value="화곡동">화곡동</option>
		                             <option value="목동">목동</option>`;
							
						   $("#town").html(str);				
						} else {
							str+= `<option value="오금동">오금동</option>
			                   	   <option value="오류동">오류동</option>
			                       <option value="상일동">상일동</option>`;
			                       
						   $("#town").html(str);        
							   }					
					})     	
            })
            </script>
            <h5>판매자 정보</h5>
            <div class="user_info" style="display: flex; margin-bottom: 30px; ">
			 <h4 style="line-height: 100%; margin:2px; margin-right: 15px;"><%=loginMember.getMemNickname()%>  <%=loginMember.getMemPhone() %></h4>    
            <button class="btn btn-success" id="emailCheck">이메일 인증</button>
            </div>
            <h6 align="center">사진은 최대 5개까지 업로드가 가능합니다.</h6>
            <div id="preview_frame">
            
            </div>
            <div class="image_upload" style="margin-top:15px ;">
                <input type="file" onchange="setThumbnail(event);" name="file" id="picture_uploader" accept="image/*" multiple  required>
        </div>
            <div class="textarea_wrapper" style="margin: 30px 30px 10px 30px;">
            <textarea name="content" id="editor"></textarea>
        </div>
            <div class="submit_button_wrapper">
                <div></div>
                <button type="submit" class="btn btn-success" id="uploadBtn" style="margin-bottom:10px">게시글 올리기</button>
            </div>
        </form>
    </div>
    <script>
        ClassicEditor
            .create(document.querySelector( '#editor' ) , {
               
                removePlugins: ['ImageUpload']
            } )  
            .catch( error => {
                console.error( error );
            } );
    </script>
    <script>
        function setThumbnail(event){

                        let preview = document.querySelector("div#preview_frame");
                        let fileCounter = document.getElementById("picture_uploader").files.length;
                        let uploadButton = document.getElementById("uploadBtn");	
                        if(fileCounter<=5) {

                        document.getElementById("picture_uploader").addEventListener("change", function() {
                        console.log(this.files.length);
                        });

                        while(preview.hasChildNodes()){
                            preview.removeChild(preview.firstChild);
                        };

                        for (let image of event.target.files){
                            let reader = new FileReader();
                

                        reader.onload = function(event){
                            /* <div class="image_wrapper">
                        <img src="../Common/images/맥북.jpg" alt="">
                        <i class="far fa-times-circle" onclick="deletePic(event);"></i>
                        </div> */
                            let preview_Wrapper = document.createElement('div');
                            preview_Wrapper.setAttribute('class','image_wrapper');
                            let img = document.createElement('img');
                            img.setAttribute("src",event.target.result);
                            preview.appendChild(preview_Wrapper);
                            preview_Wrapper.appendChild(img);
                          

                        };
                    reader.readAsDataURL(image);
                    uploadButton.disabled=false;
                    };
                    } else if(fileCounter>5) {
                    alert("사진은 최대 5개까지만 업로드가 가능합니다. 5개 이하로 사진을 선택해 주십시오.")
                    
                    
                    uploadButton.disabled=true;
                    
                    } 
                    }
        
        $(function(){
        	
        	
        	$("#emailCheck").click(function(){
        		
        		$.ajax({
        			url:"emailCheck.sh",
        			type:"post",
        			data:{
        				userEmail:"<%=to%>"	
        			},
        			success:function(){
        			console.log("성공");
        				
        			},    			
        		})
      		
        	})
        	
        })
    </script>    
<%@ include file="../common/footerbar.jsp"%>
</body>
</html>