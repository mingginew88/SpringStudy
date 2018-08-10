<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-1.12.4.js"></script>
<script src="/js/js.cookie.js"></script>
<script>
$(document).ready(function(){
	$("#language").on("click", function(){
		var result = $("#language option:selected").val();
		var result2 = $("#language option:selected").text();
		
		alert(result2);
		$("#frmLang").submit();
	});
});
</script>
</head>
<body>
	<spring:message code="userId"/>   : <input type="text" name="userId">	<br>
	<spring:message code="password"/> : <input type="text" name="password">	<br>
	
	<h3>localeChange</h3>
	<form action="/locale/view" id="frmLang">
		<select name="language" id="language">
			<c:forEach items="${localeMap}" var="locale">
				<option value="${locale.key}">${locale.value}</option>
			</c:forEach>
		</select>
	</form>
	
</body>
</html>