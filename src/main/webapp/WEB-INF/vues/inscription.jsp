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
		
		<form action="./inscription" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label for="inpNom">Nom :</label></td>
			            <td><input id="inpNom" name="NOM" type="text" placeholder="Nom" class="form-control"></td>
					</tr>
					<tr>
						<td><label for="inpPrenom">Prénom :</label></td>
			            <td><input id="inpPrenom" name="PRENOM" type="text" placeholder="Prénom" class="form-control"></td>
					</tr>
					<tr>
						<td><label for="inpEmail">E-mail :</label></td>
			            <td><input id="inpEmail" name="EMAIL" type="text" placeholder="E-mail" class="form-control"></td>
					</tr>
					<tr>
						<td><label for="inpDateNaissance">Date de naissance :</label></td>
			            <td><input id="inpDateNaissance" name="DATENAISSANCE" type="text" placeholder="Date de naissance" class="form-control"></td>
					</tr>
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
		
		<% if (request.getAttribute("BADREQUEST") != null) { %>
			<div id="bad">
				Mauvaises valeurs
			</div>
		<% } else if (request.getAttribute("DUPLICATE") != null) {%>
			<div id="bad">
				Utilisateur existe déjà
			</div>
		<% } %>
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>