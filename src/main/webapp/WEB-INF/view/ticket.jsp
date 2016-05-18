<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>
	<div align="center">
		<form action="${pageContext.request.contextPath}/ticket" method="POST">
			<table border="1">
				<tr>${errorMessage}</tr>
				<tr>
					<td colspan="2" align="center"><h2>MOUNT EVEREST AIRLINES</h2></td>
				</tr>

				<tr>
					<td>Passenger Name:</td>
					<td>Flight Number:</td>
				</tr>
				<tr>
					<td>From:</td>
					<td>To:</td>

				</tr>
				<tr>
					<td>Address:</td>
					<td>Gender:</td>

				</tr>
				<tr>
					<td>Passenger Name:</td>
					<td>Flight Number</td>

				</tr>
				<tr>
					<td>Seat Number:</td>
					<td>Price:</td>
				</tr>
			</table>
			<table>
				<tr>
					<td>Travel Date</td>
					<td>Flight Segment</td>
					<td>Flight Summary</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Conform" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>