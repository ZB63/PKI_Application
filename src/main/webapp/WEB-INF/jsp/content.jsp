<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>PKI Application</h2>

    <h2>Witaj ${email}!</h2>

	<ul>
		<c:forEach var="listValue" items="${users}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>

	<br/><a href = "logout">Wyloguj!</a>
</body>
</html>