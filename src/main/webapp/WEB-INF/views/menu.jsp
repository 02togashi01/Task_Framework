<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

   <c:if test="${empty Name}">
    <meta http-equiv="Refresh" content="0;URL=index.jsp">
  </c:if>
   <c:if test="${not empty Name}">
    <p>${Name}さん、こんにちは</p>
  </c:if>

<p><a href="select">検索</a></p>
<p><a href="insert">登録</a></p>
<p><a href="update">更新</a></p>
<p><a href="delete">削除</a></p>
<form action="logout" method="post">
  <input type="submit" value="ログアウト">
</form>
</body>
</html>
