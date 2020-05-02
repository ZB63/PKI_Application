<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC and List Example</h2>

    <h1>Witaj ${email}!</h1>

	<ul>
		<c:forEach var="listValue" items="${users}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>

	<br/><a href = "logout">Wyloguj!</a>
</body>
</html>