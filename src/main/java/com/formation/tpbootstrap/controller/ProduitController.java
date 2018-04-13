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

import com.formation.tpbootstrap.beans.Produit;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@RequestMapping(method = RequestMethod.GET)
	public String produitGet(@RequestParam(value="id") final int id, final ModelMap pModel) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root = "root";
		String mdp = "Pass123!";
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		Produit produit = new Produit();
		
		try {
			// Chargement du Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Chargement ok !");
			
			// Etablit la connexion
			connexion = DriverManager.getConnection(url, root, mdp);
			System.out.println("Connexion BDD ok !");
			
			// Requete
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM PRODUITS WHERE id = " + id + "");
			// aussi executeUpdate pour faire un changement dans la BDD
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				int quantite = resultat.getInt("quantite");
				float prix = resultat.getFloat("prix");
				String description = resultat.getString("description");
				
				produit.setId(id);
				produit.setTitre(nom);
				produit.setQuantite(quantite);
				produit.setPrix(prix);
				produit.setDescription(description);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("erreur1 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("erreur2 : " + e.getMessage());
		} finally {
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
		
		pModel.addAttribute("prod", produit);
		
		return "produit";
	}
	
}
