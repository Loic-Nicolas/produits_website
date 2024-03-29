<%@ page import="com.formation.tpbootstrap.beans.*, java.util.List" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gestion</title>
		<jsp:include page="./inc/_css.jsp"></jsp:include>
		<script src="/tpbootstrap/ressources/modifier.js"></script>
	</head>
	<body>
		<jsp:include page="./inc/_header.jsp"></jsp:include>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th style="width:20%;">Nom</th>
					<th style="width:10%;">Quantit�</th>
					<th style="width:15%;">Prix</th>
					<th style="width:25%;">Description</th>
					<th style="width:10%;">Modifier</th>
					<th style="width:10%;">Supprimer</th>
				</tr>
			</thead>
			
			<tbody>
				<%if (request.getAttribute("listeBillets") != null) {
			    	List listeBillets = (List)request.getAttribute("listeBillets");
			    	for (int i = 0; i < listeBillets.size(); i++) {
			    		Produit produit = (Produit)listeBillets.get(i);
				%>
					<tr id="id_<%=produit.getId() %>">
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
			        	<td>
			        		<button name="data" type="button" class="button_gestion button_blueho" onclick="affiche(<%=produit.getId() %>, '<%=produit.getTitre() %>',
			        		'<%=produit.getQuantite() %>', '<%=produit.getPrix() %>', '<%=produit.getDescription() %>')">Modifier</button>
			        	</td>
			        	<td>
			        		<form action="./gestion" method="POST">
			        			<input name="supprimer" type="hidden" value="true">
			        			<input name="prodId" type="hidden" value="<%=produit.getId() %>">
			        			<input type="submit" value="Supprimer" class="button_gestion button_redho">
			        		</form>
			        	</td>
			        </tr>
				<%	}
			    }%>
			</tbody>
		</table>
		
		<p style="text-align:center;"><button id="boutton_envoyer_mod" name="envoi" class="button_gestion" onclick="envoyer()" style="display: none;">Envoyer</button></p>
    	
    	<form id="form_mod" action="./gestion" class="table table-striped" method="POST">
			<input name="modifier" type="hidden" value="true">
			<input id="list_ids" name="list_ids" type="hidden" value="">
			<input id="list_titres" name="list_titres" type="hidden" value="">
			<input id="list_quantites" name="list_quantites" type="hidden" value="">
			<input id="list_prix" name="list_prix" type="hidden" value="">
			<input id="list_descriptions" name="list_descriptions" type="hidden" value="">
     		<!-- <input id="boutton_envoyer_mod" type="hidden" value="Envoyer" class="button_gestion"> -->
    	</form>
    	
    	<% if (request.getAttribute("BADREQUEST") != null) {%>
			<div id="bad">
				Valeurs invalides
			</div>
		<% } %>
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>