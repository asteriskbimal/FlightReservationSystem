<%@page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<link rel="stylesheet" href="css/form.css">
<body>
 <sec:authorize access="isAuthenticated()">  
        <strong><sec:authentication property="principal.username"/></strong>
    </sec:authorize>
<p>${message}</p>
<div id="header">

	<nav>	
			<ul>				
				 <sec:authorize access="!isAuthenticated()">  
				<li><a href="login"><h3>Login</h3></a></li>
				</sec:authorize> 
				<sec:authorize access="!isAuthenticated()">  
				<li><a href="register"><h3>Register</h3></a></li>
				 </sec:authorize>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="flight"><h3>Add Flight</h3></a></li>
				 </sec:authorize>
				 <sec:authorize access="isAuthenticated()">  
				<li><a href="logout"><h3>Logout</h3></a></li>
				</sec:authorize> 
						
			</ul>                
	</nav>	
</div>

<div>

<h1>Flight Search</h1>
<div id="login-box">
<form name='search'	action="flightSearch" method='POST'>

			<table>
				<tr>
					<td>FROM:</td>
					<td><input type='text' name='from'/></td>
					
					<td>TO:</td>
					<td><input type='text' name='to'/></td>
				</tr>
				<tr>
					<td>DEPARTURE DATE:</td>
					<td><input type='date' name='departureDate' /></td>
					
				</tr>
				<tr>
					<td colspan='2'><input name="submit" type="submit"
						value="submit" /></td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
</form>
</div>
</div>
</body>
</html>