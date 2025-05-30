<%--
  Created by IntelliJ IDEA.
  User: THILAN VIMUKTHI
  Date: 09/05/2025
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Courses</title></head>
<body>
<h2>Available Courses</h2>
<table border="1">
  <tr><th>Name</th><th>Instructor</th><th>Credits</th><th>Action</th></tr>
  <c:forEach var="course" items="${courses}">
    <tr>
      <td>${course.name}</td>
      <td>${course.instructor}</td>
      <td>${course.credits}</td>
      <td>
        <form action="${pageContext.request.contextPath}/register" method="post">
          <input type="hidden" name="courseId" value="${course.courseId}" />
          <input type="submit" value="Register" />
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
