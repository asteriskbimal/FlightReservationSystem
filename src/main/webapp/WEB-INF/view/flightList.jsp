<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>Flight Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;} 
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;} 
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;} 
 		.tg .tg-4eph{background-color:#f9f9f9} */
	</style>
</head>
<body bgcolor="gray">
<h4>


<h1>
	Add a Flight
</h1>


<br>
<sec:authorize access="isAnonymous()">	
			<td><a href="login" ><h3>Login for Booking</h3></a></td>
			 </sec:authorize>

<h3>Flights List</h3>

	<table class="tg">
	<tr>
		<th width="80">Flight ID</th>
		<th width="80">Departure Date</th>
		<th width="120">Arrival Date</th>
		<th width="120">Available Seats</th>
		<th width="120">From</th>
		<th width="120">TO</th>
		
	</tr>
	
	<c:forEach items="${listflights}" var="flight">
		<tr>
			<td>${flight.flightId}</td>
			<td>${flight.departureDate}</td>
			<td>${flight.arrivalDate}</td>
			<td>${flight.availSeats}</td>
			<td>${flight.fromLocation}</td>
			<td>${flight.toLocation}</td>
			<sec:authorize access="hasAnyRole('ROLE_USER')">	
			<td><a href="<c:url value='/details/${flight.flightId}' />" >Go for Booking</a></td>
			</sec:authorize>
			 
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<td><a href="<c:url value='/edit/${flight.flightId}' />" >Edit</a></td>
			<td><a href="<c:url value='/delete/${flight.flightId}' />" >Delete</a></td>
			 </sec:authorize>
			 </tr>
	</c:forEach>
	</table>
</body>
</html>
