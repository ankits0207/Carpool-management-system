<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<%ResourceBundle bundleFR = ResourceBundle.getBundle("LoginPage_FRENCH",Locale.FRENCH);%>
<form action="./Controller">
<%=bundleFR.getString("Username")%>:<input type="text" name="username"><br><br>
<%=bundleFR.getString("Password")%>:<input type="password" name="pwd"><br><br>
<input type="submit" value="Submit" name="submit">
</form>
</body>
</html>