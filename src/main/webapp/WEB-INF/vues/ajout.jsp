<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ajout</title>
		<jsp:include page="./inc/_css.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="./inc/_header.jsp"></jsp:include>
		
		<section>
			<form action="./ajout" method="POST">
			    <table>
			        <tr>
			            <td><label for="inpTitre">Titre :</label></td>
			            <td><input id="inpTitre" name="TITRE" type="text" placeholder="Titre du produit" class="form-control"></td>
			        </tr>
			        <tr>
			            <td><label for="inpPrix">Prix :</label></td>
			            <td><input id="inpPrix" name="PRIX" type="text" placeholder="Prix du produit" class="form-control"></input></td>
			        </tr>
			        <tr>
			            <td><label for="inpQuantite">Quantite :</label></td>
			            <td><input id="inpQuantite" name="QUANTITE" type="text" placeholder="Quantite de produit" class="form-control"></input></td>
			        </tr>
			        <tr>
			            <td><label for="inpDescription">Description :</label></td>
			            <td><input id="inpDescription" name="DESCRIPTION" type="text" placeholder="Description du produit" class="form-control"></input></td>
			        </tr>
			        <tfoot>
			            <tr>
			                <td colspan="2"><input type="submit" value="Envoyer" class="submit button_blueho"></td>
			            </tr>
			        </tfoot>
			    </table>
			</form>
			
			<% if (request.getAttribute("ADDED") != null) {%>
			<div id="added">
				Produit ajouté
			</div>
			<% } %>
			
			<% if (request.getAttribute("BADREQUEST") != null) {%>
			<div id="bad">
				Valeurs invalides
			</div>
			<% } %>
			
		</section>
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>