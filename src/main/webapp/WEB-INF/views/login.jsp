<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
 <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form:form action="login" method="post" modelAttribute="command" >
  <p>
  <label>ID</label><form:input path="id" />
  </p>
  <p>
  <label>PASS</label><form:password path="pass" />
  </p>
  <form:button>ログイン</form:button>
</form:form>

<div>
  <a href="index">TOP画面へ</a>
</div>
</body>
</html>
