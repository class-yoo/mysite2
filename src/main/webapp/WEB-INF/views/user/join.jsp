<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
/* $(function () {
	$('#email').change(function() { // focus에 따라 이전 내용과 같은지 체크함
		$('check-button').show();
		$('#check-image').hide();
	})
	
	$('#check-button').click(function () {
		var email = $('#email').val();
		if(email == ''){
			return;
		}
		
		
		
		$.ajax({
			
			url: "${pageContext.servletContext.contextPath}/user/api/checkemail="+ email, // get방식으로하고 url로 보내기 post일경우 data 항목에 넣어줘야함
			type: "get", // 메소드방식 get/ post
			dataType: "json", 
			data: "",
			success : function (response) { // 성공 후 날아오는  응답을 json을 객체로 만들어서 인자로 들어옴
				if(response.result != "success"){
					console.error(response.message);
					return;
				}
			
			if(response.data == true){
				alert('이미 존재하는 이메일입니다. 다른 이메일을 사용해주세요');
				$('#email').focus();
				$('#email').val('');
				return;
			}
				$('check-button').hide();
				$('#check-image').show();
			},
			error: function (xhr, error) { // 요청에 대한 응답 실패 후  XmlHttpResponse ? 가 인자로 들어옴
					console.error("error:"+ error);
			}
		});
			
		
		
		console.log(email);
	});
}); 
*/
$(function(){
	   $('#email').change(function(){
	      $('#check-button').show();
	      $('#check-img').hide();      
	   })
	   $('#check-button').click(function(){
	      var email = $('#email').val();
	      if(email==''){
	         return ;
	      }
	      
	      /*ajax 통신 */
	      $.ajax({
	         url:"${pageContext.servletContext.contextPath }/user/api/checkemail?email=" + email,
	         type:"get",
	         dataType:"json",
	         data:"",
	         success:function(response){
	            if(response.result != "success"){
	               console.log(response.message);
	               return ;
	            }
	            
	            if(response.data == true){
	               alert('이미 존재하는 이메일입니다.\n다른 이메일 사용 ㄱ')
	               $('#email').focus();
	               $("#email").val("");
	               return;
	            }
	            
	            $('#check-button').hide();
	            $('#check-image').show();
	            
	            
	         },
	         error:function(xhr, error){ 
	            console.error("error:" + error) 
	         }
	      });
	      console.log(email);
	   })
	});
	


</script>

</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post" action="${pageContext.servletContext.contextPath}/user/join">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<input type="button" id="check-button" value="중복체크">
					<img style="display: none" id ="check-image" src="${pageContext.servletContext.contextPath}/assets/images/ok.png">
					
					
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
		<!-- 파일을 생성해두고 불러와서 적용 -->
	</div>
</body>
</html>