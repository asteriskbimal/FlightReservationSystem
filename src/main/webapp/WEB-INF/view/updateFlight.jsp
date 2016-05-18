<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>
	<form action="editFlight" method="POST" modelAttribute="flight" >
	<table>
	<tr>
			<td>
	<input type="text" hidden="true" name="flightId" value="${flight.flightId}"/> </td>
		<tr>
			<td>FlightCode:</td>
			<td><input type="text" name="flightCode" value="${flight.flightCode}"/> </td>
		</tr>
		<tr>
			<td>From:</td>
			<td><input type="text" name="fromLocation" value="${flight.fromLocation}" /> </td>
		</tr>
		<tr>
			<td>To:</td>
			<td><input type="text" name="toLocation" value="${flight.toLocation}"/> </td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" value="${flight.price}"/> </td>
		</tr>
		<tr>
			<td>Departure:</td>
			<td><input type="date"  name="departureDate1" value="${flight.departureDate}"/> </td>
		</tr>
		<tr>
			<td>Arrival:</td>
			<td><input  type="date"  name="arrivalDate1" value="${flight.arrivalDate}"/> </td>
		
		</tr>
		<tr>
			<td>Avail Seats:</td>
			<td><input type="number" name="availSeats" value="${flight.availSeats}" /> </td>
		</tr>
	</table>
	<input type="submit"/>
	<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
	</form>

</body>
</html>