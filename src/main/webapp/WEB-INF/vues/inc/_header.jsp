<%@ page import="com.formation.tpbootstrap.beans.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    	<header>
    		<div style="height: 6em;" id="titre">
    			<span id="nomBlog"><h1>Produits</h1></span>
    		</div>
    		
    		<section id="message_user">
    		<% if (session.getAttribute("utilisateur") != null) { 
    			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
    		%>
	   			<span id="message_perso">
	   				Bienvenue <%= utilisateur.getPrenom() + " " + utilisateur.getNom() %>
	   				
	   				<section>
	    				<form action="<%=request.getContextPath() %>/" method="POST">
			    			<input id="button_deconnecter" name="deconnexion" type="submit" value="Déconnexion" class="button_header">
			    		</form>
	   				</section>
	   			</span>
    		<% } else { %>
    			<a target="_self" href="<%=request.getContextPath() %>/login" class="liens">
    			<button id="button_connecter" name="connexion" class="button_header">Connexion</button>
    			</a>
    			
    			<a target="_self" href="<%=request.getContextPath() %>/inscription" class="liens">
    			<button id="button_inscrire" name="inscription" class="button_header" onclick="">Inscription</button>
    			</a>
    		<% } %>
    		</section>
    		
		</header>
		<hr>
		
		<nav>
		    <a target="_self" href="<%=request.getContextPath() %>/" class="liens">Accueil</a> - <a target="_self" href="<%=request.getContextPath() %>/referencement" class="liens">Référencement</a> - <a target="_self" href="<%=request.getContextPath() %>/ajout" class="liens">Ajout</a> - <a target="_self" href="<%=request.getContextPath() %>/user/gestion" class="liens">Gestion</a>
		</nav>
		
		<section>