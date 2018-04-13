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
				<%}%>
			</tbody>
		</table>
		
		<jsp:include page="./inc/_footer.jsp"></jsp:include>
	</body>
</html>