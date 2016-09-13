<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>myapp</title>
</head>
<body>
	<c:if test="${not empty name}">
		Hello ${name}
	</c:if>
	
	<c:if test="${empty name}">
		Welcome Welcome!
	</c:if>



</body>
</html>