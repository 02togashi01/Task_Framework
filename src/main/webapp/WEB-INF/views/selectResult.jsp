<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果画面</title>
<link href="/css/commons.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>検索結果</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>名前</th>
				<th>TEL</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="Userinfo" items="${UserinfoList}">
				<tr>
					<td>${fn:escapeXml(Userinfo.usersId)}</td>
					<td>${fn:escapeXml(Userinfo.usersName)}</td>
					<td>${fn:escapeXml(Userinfo.telephone)}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="menu">メニューに戻る</a>
	</div>
</body>
</html>
