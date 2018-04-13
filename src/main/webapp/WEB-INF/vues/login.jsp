<%@ page import="com.formation.tpbootstrap.beans.*, java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<jsp:include page="./inc/_css.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="./inc/_header.jsp"></jsp:include>
		
		<form action="./login" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label for="inpLogin">Login :</label></td>
			            <td><input id="inpLogin" name="LOGIN" type="text" placeholder="Login" class="form-control"></td>
					</tr>
					<tr>
						<td><label for="inpMdp">Mot de passe :</label></td>
			            <td><input id="inpMdp" name="MDP" type="password" placeholder="Mot de passe" class="form-control"></td>
					</tr>
				</tbody>
				<tfoot>
		            <tr>
		                <td colspan="2"><input type="submit" value="Envoyer" class="submit"></td>
		            </tr>
		        </tfoot>
			</table>
		</form>
		
		<% if (request.getAttribute("BADREQUEST") != null) {
			if (request.getAttribute("BADREQUEST").equals("true")) {%>
			<div id="bad">
				Mauvaise identification
			</div>
		<% } else if (request.getAttribute("BADREQUEST").equals("false")) {%>
			<div id="added">
				Bienvenue !
			</div>
		<% } }%>
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>