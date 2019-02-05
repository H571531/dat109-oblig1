<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>!!! YATZOO !!!</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="Resultat">
	<table>
		<tr>
			<td></td>
			<c:forEach var="spiller" items="${spill.spillere}">
				<td><c:out value="${spiller.navn}"></c:out></td>
			</c:forEach>
		
		</tr>
		
		<c:forEach var="rundeBilde" items="${spill.ark.bildeURLs}" varStatus="i">
			<tr>
				<td><img src="${rundeBilde}" width="50">
				</td>
				<c:forEach var="spiller" items="${spill.spillere}">
					<td>${spiller.resultater[i.index]}</td>
				</c:forEach>
			</tr>
		</c:forEach>
		
		
		
		<tr>
			<td><strong>SUM: </strong></td>
			<c:forEach var="spiller" items="${spill.spillere}">
				<td>${spiller.sum}</td>
			</c:forEach>
		</tr>
		
	</table>
	
	<br><br><br>
	Vinner: <strong>${spill.vinner.navn}</strong>
	
	<form action="YatzooServlet" method="get">
		<button type="submit">Spill på nytt</button>
	</form>
</div>
</body>
</html>