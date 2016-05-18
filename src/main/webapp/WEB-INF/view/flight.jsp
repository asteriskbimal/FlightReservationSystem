<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h4>User:</h4><sec:authorize access="isAuthenticated()">  
        <strong><sec:authentication property="principal.username"/></strong>
    </sec:authorize>
<h3>Add Flight Details</h3>
	<form action="addFlight" method="post" >
	<table>
		<tr>
			<td>FlightCode:</td>
			<td><input type="text" name="flightCode" /> </td>
		</tr>
		<tr>
			<td>From:</td>
			<td><input type="text" name="fromLocation" /> </td>
		</tr>
		<tr>
			<td>To:</td>
			<td><input type="text" name="toLocation" /> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" /> </td>
		</tr>
		<tr>
			<td>Flight Status:</td>
			<td><input type="text" name="flightStatus" /> </td>
		</tr>
		<tr>
			<td>Departure Date:</td>
			<td><input type="date" name="departureDate" /> </td>
		</tr>
		<tr>
			<td>Arrival Date:</td>
			<td><input  type="date"  name="arrivalDate" /> </td>
		
		</tr>
				<tr>
			<td>Departure Time:</td>
			<td><input type="time"  name="departureTime" /> </td>
		</tr>
		<tr>
			<td>Arrival Time:</td>
			<td><input type="time"  name="arrivalTime" /> </td>
		</tr>
		<tr>
			<td>Avail Seats:</td>
			<td><input type="number" name="availSeats" /> </td>
		</tr>
	</table>
	<input type="submit"/>
	<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
	</form>

</body>
</html>