<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Money</title>
<script type="text/javascript">
	 function validate(){
		var id=document.myform.balance.value;
		if(id==0){
			alert("Amount should not be null.");
			return false;
		}
	}
</script>
</head>
<body>
<form name="myform" action="../addMoney" method="post" onclick="return validate()">
Enter your uid :<input type="number" name="uid" required="required"><br>
Enter amount : <input type="number" name="balance" required="required"> <br>
<input type="submit" name="Submit"/>
</form>
</body>
</html>