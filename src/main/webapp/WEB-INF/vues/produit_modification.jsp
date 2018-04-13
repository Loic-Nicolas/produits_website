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
		
		<form action="./produit" method="POST">
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
					<%if (request.getAttribute("prod") != null) {
				    	Produit produit = (Produit)request.getAttribute("prod");
					%>
						<tr>
							<input name="prodId" type="hidden" value="<%=produit.getId() %>">
				        	<td>
				            	<input name="TITRE" type="text" placeholder="<%=produit.getTitre() %>" value="<%=produit.getTitre() %>">
				        	</td>
				        	<td>
				        		<input name="QUANTITE" type="text" placeholder="<%=produit.getQuantite() %>" value="<%=produit.getQuantite() %>">
				        	</td>
				        	<td>
				        		<input name="PRIX" type="text" placeholder="<%=produit.getPrix() %> euros" value="<%=produit.getPrix() %>">
				        	</td>
				        	<td>
				        		<input name="DESCRIPTION" type="text" placeholder="<%=produit.getDescription() %>" value="<%=produit.getDescription() %>">
				        	</td>
				        </tr>
					<%}%>
				</tbody>
				
				<tfoot>
		            <tr>
		                <td colspan="4"><input name="modifier" type="hidden" value="true">
		            	<input type="submit" value="Envoyer" class="submit"></td>
		            </tr>
		        </tfoot>
			</table>
			
		</form>
		
		<% if (request.getAttribute("BADREQUEST") != null) {%>
		<div id="bad">
			Valeurs invalides
		</div>
		<% } %>
		
		
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>