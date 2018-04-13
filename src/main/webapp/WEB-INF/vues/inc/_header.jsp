<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    	<header>
    		<div style="height: 6em;" id="titre">
    			<span id="nomBlog"><h1>Produits</h1></span>
    		</div>
    		<p id="message_user">
    			<a target="_self" href="<%=request.getContextPath() %>/login" class="liens">
    			<button id="button_connecter" name="connexion" class="button_header">Connexion</button>
    			</a>
    			
    			<button id="button_inscrire" name="inscription" class="button_header" onclick="">Inscription</button>
    		</p>
		</header>
		<hr>
		
		<nav>
		    <a target="_self" href="<%=request.getContextPath() %>/" class="liens">Accueil</a> - <a target="_self" href="<%=request.getContextPath() %>/referencement" class="liens">Référencement</a> - <a target="_self" href="<%=request.getContextPath() %>/ajout" class="liens">Ajout</a> - <a target="_self" href="<%=request.getContextPath() %>/gestion" class="liens">Gestion</a>
		</nav>
		
		<section>