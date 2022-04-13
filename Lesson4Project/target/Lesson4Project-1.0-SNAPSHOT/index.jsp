<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lesson 4 assignment</title>
</head>
<body>
<form action="" method="post">
    Enter Product ID: <input type="number" max="100" min="0" step="1" name="id"/>
    Enter Product Details: <input type="text" name="details"/>
    <input type="submit" name="register" value="Register Details">
</form>
<% if (request.getParameter("register") != null) {%>
<jsp:useBean id="newProduct" class="com.entities.Product" scope="request"></jsp:useBean>
<jsp:setProperty name="newProduct" property="*" />
<jsp:forward page="RegisterServlet" ></jsp:forward>

<% } %>

</body>
</html>