<%--
  Created by IntelliJ IDEA.
  User: THILAN VIMUKTHI
  Date: 09/05/2025
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Student Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    Email: <input type="email" name="email" required/><br/><br/>
    Password: <input type="password" name="password" required/><br/><br/>
    <input type="submit" value="Login"/>
</form>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
