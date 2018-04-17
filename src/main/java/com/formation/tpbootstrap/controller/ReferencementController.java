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

import com.formation.tpbootstrap.beans.Produit;

@Controller
@RequestMapping("/referencement")
public class ReferencementController {

	@RequestMapping(method = RequestMethod.GET)
	public String referencementGet(final ModelMap pModel) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root = "root";
		String mdp = "Pass123!";
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		List listeBillets = new LinkedList();
		
		try {
			// connexion à la BDD
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, root, mdp);
			statement = connexion.createStatement();
			
			// on récupère la liste des produits
			resultat = statement.executeQuery("SELECT * FROM PRODUITS");
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				int quantite = resultat.getInt("quantite");
				float prix = resultat.getFloat("prix");
				String description = resultat.getString("description");
				int id = resultat.getInt("id");
				
				Produit produit = new Produit();
				produit.setId(id);
				produit.setTitre(nom);
				produit.setQuantite(quantite);
				produit.setPrix(prix);
				produit.setDescription(description);
				
				listeBillets.add(produit);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("erreur1 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("erreur2 : " + e.getMessage());
		} finally { // on ferme les objets de connexion
			if (resultat != null) {
				try {
					resultat.close();
				} catch (SQLException e) {
					System.out.println("erreur3 : " + e.getMessage());
				}
			}
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
		
		pModel.addAttribute("listeBillets", listeBillets);
		
		return "referencement";
	}
}
