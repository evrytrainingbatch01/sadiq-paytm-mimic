<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer money</title>
</head>
<body>
<form action="./transfer" method="post">
Enter your uid : <input type="number" name="uid" required="required">
Enter beneficiary uid : <input type="number" name="bid" required="required"/><br>
Enter the amount : <input type="number" name="amt" required="required"/><br>
<input type="submit" name="Submit"/>
</form>
</body>
</html>