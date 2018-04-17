package com.formation.tpbootstrap.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {

	@RequestMapping(method = RequestMethod.GET)
	public String inscriptionGet(final ModelMap pModel) {
		
		
		
		return "inscription";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String inscriptionPost(final ModelMap pModel, @RequestParam(value="NOM", defaultValue="") final String nom,
			@RequestParam(value="PRENOM", defaultValue="") final String prenom, @RequestParam(value="EMAIL", defaultValue="") final String email,
			@RequestParam(value="DATENAISSANCE", defaultValue="") final String dateNaissance, @RequestParam(value="LOGIN", defaultValue="") final String login,
			@RequestParam(value="MDP", defaultValue="") final String mdp) {
		
		// on vérifie que les champs de la requête sont valides
		if (nom.equals("") || prenom.equals("") || email.equals("") || dateNaissance.equals("") || login.equals("") || mdp.equals("")) {
			pModel.addAttribute("BADREQUEST", true);
		} else {
			String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
			String root = "root";
			String mdp_sql = "Pass123!";
			
			Connection connexion = null;
			Statement statement = null;
			int resultat = 0;
			
			try {
				// connexion à la BDD
				Class.forName("com.mysql.cj.jdbc.Driver");
				connexion = DriverManager.getConnection(url, root, mdp_sql);
				statement = connexion.createStatement();
				// on rajoute l'utilisateur dans la BDD
				resultat = statement.executeUpdate("INSERT INTO produits.utilisateurs (nom, prenom, email, date_naissance, login, mdp) VALUES ('" + nom + "', '" + prenom + "', '" + email + "', '" + dateNaissance + "', '" + login + "', '" + mdp + "');");
			} catch (ClassNotFoundException e) {
				System.out.println("erreur1 : " + e.getMessage());
			} catch (SQLException e) {
				System.out.println("erreur2 : " + e.getMessage());
				System.out.println("code : " + e.getErrorCode());
				if (e.getErrorCode() == 1062) {
					pModel.addAttribute("DUPLICATE", true);
				}
			}
		}
		
		return "inscription";
	}
	
}
