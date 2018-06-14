<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="3;URL=index.jsp">
<title>ログアウト</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<form:form action="logout" method="post" modelAttribute="command">
		<div class="center">
			<p>
				ログアウトしました。<br> ※３秒後にTOP画面に遷移します。
			</p>
		</div>
	</form:form>
</body>
</html>
