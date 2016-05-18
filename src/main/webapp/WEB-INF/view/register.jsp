<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/pathm.css">
<body>

	<div class="register">
		<h3>Create your account</h3>
		<form:form method="post" modelAttribute="person" action="registerSave">
			<table>
				<tr>
					<td><label class="control-label" for="">Username</label></td>
					<td><form:input path="user.userName" type="text"  /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">Password</label></td>					
						<td><form:input path="user.password" type="password" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">First Name</label></td>
					<td><form:input path="firstName" type="text" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">Last Name</label></td>
					<td><form:input path="lastName" type="text" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">Email</label></td>
					<td><form:input path="address.email" type="text" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">City</label></td>
					<td><form:input path="address.city" type="text" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">State</label></td>
					<td><form:input path="address.state" type="text" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">Country</label></td>
					<td><form:input path="address.country" type="text" /></td>
				</tr>
				<tr>
					<td><label class="control-label" for="">Zip</label></td>
					<td><form:input path="address.zip" type="text" /></td>
				</tr>
			</table>
			<button type="submit">Register</button>
		</form:form>
	</div>
</body>
</html>