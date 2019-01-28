<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>!!! YATZOO !!!</title>
</head>
<body>
	<table>
		<tr>
			<td></td>
			<c:forEach var="spiller" items="${spill.spillere}">
				<td><c:out value="${spiller.navn}"></c:out></td>
			</c:forEach>
		
		</tr>
		
		<c:forEach var="rundeNavn" items="${spill.ark.rundeNavn}" varStatus="i">
			<tr>
				<td>${rundeNavn}
				</td>
				<c:forEach var="spiller" items="${spill.spillere}">
					<td>${spiller.resultater[i.index]}</td>
				</c:forEach>
			</tr>
		</c:forEach>
		
		
		<br />
		<tr>
			<td><strong>SUM: </strong></td>
			<c:forEach var="spiller" items="${spill.spillere}">
				<td>${spiller.sum}</td>
			</c:forEach>
		</tr>
		
	</table>
	
	<br><br><br>
	Vinner: <strong>${spill.vinner.navn}</strong>
	
	<form action="YatzooSpillServlet" method="post">
		<button type="submit">Spill på nytt</button>
	</form>
	

</body>
</html>