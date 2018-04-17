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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.tpbootstrap.beans.Produit;

@Controller
@RequestMapping("/ajout")
public class AjoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String ajoutGet(final ModelMap pModel) {
		
		return "ajout";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String ajoutPost(@RequestParam(value="TITRE") final String titre, @RequestParam(value="PRIX") final String prix_str,
			@RequestParam(value="QUANTITE") final String quantite_str, @RequestParam(value="DESCRIPTION") final String description, 
			final ModelMap pModel) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root = "root";
		String mdp = "Pass123!";
		
		Connection connexion = null;
		Statement statement = null;
		int resultat = 0;
		
		if (titre=="" || prix_str=="" || quantite_str=="" || description=="") {
			pModel.addAttribute("BADREQUEST", true);
		} else {
			try {
				int quantite = Integer.parseInt(quantite_str);
				float prix = Float.parseFloat(prix_str);
				
				try {
					// connexion à la BDD
					Class.forName("com.mysql.cj.jdbc.Driver");
					connexion = DriverManager.getConnection(url, root, mdp);
					statement = connexion.createStatement();
					
					// requête mySQL : on rajoute le produit dans la BDD
					resultat = statement.executeUpdate("INSERT INTO produits.produits (nom, quantite, prix, description) VALUES ('" + titre + "', '" + quantite + "', '" + prix + "', '" + description + "');");
					pModel.addAttribute("ADDED", true);
				} catch (ClassNotFoundException e) {
					System.out.println("erreur1 : " + e.getMessage());
				} catch (SQLException e) {
					System.out.println("erreur2 : " + e.getMessage());
				} finally { // on ferme les variables
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException e) {
							System.out.println("erreur4 : " + e.getMessage());
						}
					}
					if (connexion != null) {
						try {
							connexion.close();
						} catch (SQLException e) {
							System.out.println("erreur5 : " + e.getMessage());
						}
					}
				}
			} catch (NumberFormatException e) {
				pModel.addAttribute("BADREQUEST", true);
			}
		}
		
		return "ajout";
	}
	
}
