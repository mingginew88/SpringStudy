<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">		<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>				<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script>
	$(function(){
		$("table tbody tr").on("click", function(){
			//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
			//form태그를 submit
			$("#id").val($(this).data("id"));
			$("#frm").submit();
			console.log("table tbody tr clicked : " + $(this).data("id"));
		});
	});
</script>

</head>

<body>
	<!-- top.jsp -->	
	<tiles:insertAttribute name="top"/>
	
	<div class="container-fluid">
		<div class="row">

			<!-- left.jsp -->
			<tiles:insertAttribute name="left"/>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!-- content.jsp -->
				<tiles:insertAttribute name="content"/>
			</div>
		</div>
	</div>
</body>
</html>
    