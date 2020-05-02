<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC and List Example</h2>

	<c:if test="${not empty email}">

        <h1>Witaj ${email}!</h1>

    </c:if>

	<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${users}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>