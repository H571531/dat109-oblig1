<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="no.hvl.dat109.utils.Dyr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>!!! YATZOO !!!</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="Kast">
	<h1>RUNDE: ${spill.runde + 1}</h1>
	<h2>Spiller: ${spill.aktivSpiller.navn}</h2>

	<hr />
	<h3>${spill.ark.rundeStrings[spill.runde]}</h3>
	<hr />
	<form action="YatzooSpillRundeServlet" method="post">
		<table>
			<tr>
				
				<c:forEach var="terning" items="${spill.kopp.terninger}">
					<td>
						<c:choose>
							<c:when test="${terning.verdi == 'LOVE' }"><img src="img/love.PNG"></c:when>
							<c:when test="${terning.verdi == 'SLANGE' }"><img src="img/slange.PNG"></c:when>
							<c:when test="${terning.verdi == 'PANDA' }"><img src="img/panda.PNG"></c:when>
							<c:when test="${terning.verdi == 'GRIS' }"><img src="img/gris.PNG"></c:when>
							<c:when test="${terning.verdi == 'ELEFANT' }"><img src="img/elefant.PNG"></c:when>
							<c:when test="${terning.verdi == 'HVAL' }"><img src="img/hval.PNG"></c:when>
							
						
						
						</c:choose>
						
					</td>
				</c:forEach>
			</tr>
			<tr>
				
					<c:forEach var="i" begin="0" end="4">
						<td>
							<input type="checkbox" name="valgteTerninger" value="${i}" <c:if test="${valgteTerninger[i]}">checked</c:if>>
						</td>
					</c:forEach>
				
			</tr>
		
		</table>
		<input type="submit" value="Videre">
	</form>
	</div>
	
	<div class="Oversikt">
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
		
		
		<br />
		<tr>
			<td><strong>SUM: </strong></td>
			<c:forEach var="spiller" items="${spill.spillere}">
				<td>${spiller.sum}</td>
			</c:forEach>
		</tr>
		
	</table>
	
	</div>
	
</body>
</html>