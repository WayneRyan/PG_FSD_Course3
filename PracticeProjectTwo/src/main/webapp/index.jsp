<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - PracticeProjectTwo</title>
</head>
<body>
<form action="InsertData" method="get">
    Enter rollno <input type="text" name="txtRollNumber"><br><br>
    Enter name <input type="text" name="txtRollNumber"><br><br>
    Enter DOB <input type="date" name="txtDOB"><br><br>
    Enter mark <input type="number" min="0" max="100" step="0.01" name="txtMark"><br><br>
    <input type="submit" value="submit">
</form>
<a href="ViewRecords"> View all student Records</a>
</body>
</html>