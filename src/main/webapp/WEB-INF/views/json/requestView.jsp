<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	console.log("requestView.jsp ready");
	
	var rangers = ["brown", "cony", "sally"];
	
	$("#btn").on("click", function(){
		$.ajax({
			url : "/json/requestBody",
			method : "post",		
			contentType : "application/json; charset=utf-8",	//json전송을 알려주는 contentType
			dataType : "json",									//server로 부터 받을 data Type
			data : JSON.stringify(rangers),						//전송할 json 문자열
			success : function(data) {
				console.log(data);
				$("#screen").html(data);
			}
		});
	});
});

</script>
</head>
<body>
	<h3>requestView.jsp</h3>
	<button id="btn">전송</button>
	<div id="screen"></div>
	
</body>
</html>