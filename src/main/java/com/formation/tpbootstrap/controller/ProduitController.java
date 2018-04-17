package com.formation.tpbootstrap.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, root, mdp);
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT * FROM PRODUITS WHERE id = " + id + "");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				int quantite = resultat.getInt("quantite");
				float prix = resultat.getFloat("prix");
				String description = resultat.getString("description");
				String image= resultat.getString("image");
				
				produit.setId(id);
				produit.setTitre(nom);
				produit.setQuantite(quantite);
				produit.setPrix(prix);
				produit.setDescription(description);
				produit.setImage(image);
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
	
	@RequestMapping(method = RequestMethod.POST)
	//public @ResponseBody
	public String produitPost(@RequestParam(value="file") MultipartFile file, final ModelMap pModel, @RequestParam(value="id_produit") int id,
			@RequestParam(value="supprimer", defaultValue="") final String supprimer) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root = "root";
		String mdp = "Pass123!";
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		Produit produit = new Produit();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, root, mdp);
			statement = connexion.createStatement();
			
			if (supprimer.equals("true")) {
				statement.executeUpdate("UPDATE produits.produits SET image=NULL WHERE id = '" + id + "';");
			} else {
				if (!file.isEmpty()) {
					BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
					String fileName = "C:/Users/ib/Documents/workspace-sts-3.9.3.RELEASE/tpbootstrap/src/main/webapp/ressources/images/image_" + id + ".png";
					File destination = new File(fileName); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
					
					ImageIO.write(src, "png", destination);
					/*
					 * Pour que le changement soit pris en compte dans le projet il faut faire
					 * Window/Preferences/General/Workspace -> "Refresh using native hooks and polling" (et peut-être "Refresh on access" mais j'ai pas encore eu besoin)
					 */
					
					statement.executeUpdate("UPDATE produits.produits SET image='" + fileName + "' WHERE id = '" + id + "';");
				}
			}
			
			resultat = statement.executeQuery("SELECT * FROM PRODUITS WHERE id = " + id + "");
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				int quantite = resultat.getInt("quantite");
				float prix = resultat.getFloat("prix");
				String description = resultat.getString("description");
				String image= resultat.getString("image");
				
				produit.setId(id);
				produit.setTitre(nom);
				produit.setQuantite(quantite);
				produit.setPrix(prix);
				produit.setDescription(description);
				produit.setImage(image);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
