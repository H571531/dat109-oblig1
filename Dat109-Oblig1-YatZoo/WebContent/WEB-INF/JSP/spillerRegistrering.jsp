<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${forFaaSpillereFeilmelding}
	<form action="YatzooServlet" method="post">
		Spiller 1 navn: <input type="text" name="spiller1"><br />
		Spiller 2 navn: <input type="text" name="spiller2"><br />
		Spiller 3 navn: <input type="text" name="spiller3"><br />
		Spiller 4 navn: <input type="text" name="spiller4"><br />
		Spiller 5 navn: <input type="text" name="spiller5"><br />
		
		<button type="submit">Start spill!</button>
	
	</form>

</body>
</html>