<%@ page import="com.formation.tpbootstrap.beans.*" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestion</title>
		<jsp:include page="./inc/_css.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="./inc/_header.jsp"></jsp:include>
		
		<%if (request.getAttribute("prod") != null) {
	    	Produit produit = (Produit)request.getAttribute("prod");
		%>
		<table>
			<thead>
				<tr>
					<th>Nom</th>
					<th>Quantité</th>
					<th>Prix</th>
					<th>Description</th>
				</tr>
			</thead>
			
			<tbody>
				
					
					<tr>
			        	<td>
			        		<%=produit.getTitre() %>
			        	</td>
			        	<td>
			        		<%=produit.getQuantite() %>
			        	</td>
			        	<td>
			        		<%=produit.getPrix() %> euros
			        	</td>
			        	<td>
			        		<%=produit.getDescription() %>
			        	</td>
			        </tr>
				
			</tbody>
		</table>
		
		<div id="div_image">
			<% if (produit.getImage() != null) { %>
				<img id="image_produit" alt="<%=produit.getTitre()%>" src="/tpbootstrap/ressources/images/image_<%=produit.getId()%>.png">
			<%} %>
			
			<table style="width: 40%;">
				<tr>
					<td style="width: 60%;">
						<form method="POST" action="./produit" enctype="multipart/form-data">
							<input id="id_produit" name="id_produit" type="hidden" value="<%= produit.getId() %>">
						    Image : <input type="file" name="file" size = "50" class="button_gestion"/>
						    <br>
						    <input type="submit" value="Upload" class="button_gestion button_greenho" style="width: 30%"/>
						</form>
					</td>
					<td style="width: 40%;">
						<% if (produit.getImage() != null) { %>
							<form method="POST" action="./produit" enctype="multipart/form-data">
								<input name="supprimer" type="hidden" value="true">
								<input type="file" name="file" size = "50" style="display: none;"/>
								<input id="id_produit" name="id_produit" type="hidden" value="<%= produit.getId() %>">
								<input id="suppr" type="image" src="/tpbootstrap/ressources/images/supprimer.png" alt="Supprimer image" style="width: 5em;">
							</form>
						<%} %>
					</td>
				</tr>
			</table>
			
		</div>
		
		<%}%>
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>