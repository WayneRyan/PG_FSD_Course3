<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="AddData" method="get">
    Enter product ID <input type="number" min="1" max="4" name="productID"><br><br>
    Enter product Details <input type="text" maxlength="255" minlength="1" name="productDetails"><br><br>
    <input type="submit" value="submit">
</form>
</body>
</html>