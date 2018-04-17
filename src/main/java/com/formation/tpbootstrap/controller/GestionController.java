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
@RequestMapping("/user/gestion")
public class GestionController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String gestionGet(final ModelMap pModel) {
		
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
			
			// on récupère les produits de la BDD et on forme la liste des produits
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
		
		return "gestion";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String gestionPost(@RequestParam(value="prodId", defaultValue="-1") final int id, final ModelMap pModel, @RequestParam(value="supprimer", defaultValue="") final String supprimer, 
			@RequestParam(value="modifier", defaultValue="") final String modifier, @RequestParam(value="list_ids", defaultValue="") final String list_ids,
			@RequestParam(value="list_titres", defaultValue="") final String list_titres, @RequestParam(value="list_prix", defaultValue="") final String list_prix,
			@RequestParam(value="list_quantites", defaultValue="") final String list_quantites, @RequestParam(value="list_descriptions", defaultValue="") final String list_descriptions) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root = "root";
		String mdp = "Pass123!";
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		List listeBillets = new LinkedList();
		
		// connexion à la BDD
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, root, mdp);
			statement = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("erreur1 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("erreur2 : " + e.getMessage());
		}
		
		// si on a cliqué sur MODIFIER
		if (modifier.equals("true")) {
			String[] id_mod_str = list_ids.split("- -");
			String[] titre_mod = list_titres.split("- -");
			String[] prix_mod_str = list_prix.split("- -");
			String[] quantite_mod_str = list_quantites.split("- -");
			String[] description_mod = list_descriptions.split("- -");
			
			boolean check = true;
			
			// vérification que les champs de la requête sont valides
			for (int i = 0; i < id_mod_str.length; i++) {
				if (titre_mod[i]=="" || prix_mod_str[i]=="" || quantite_mod_str[i]=="" || description_mod[i]=="") {
					pModel.addAttribute("BADREQUEST", true);
					check = false;
				} else {
					try {
						int quantite_mod = Integer.parseInt(quantite_mod_str[i]);
						float prix_mod = Float.parseFloat(prix_mod_str[i]);
					} catch (NumberFormatException e) {
						pModel.addAttribute("BADREQUEST", true);
						check = false;
					}
				}
			}
			
			// si c'est valide, on fait la mise à jour des produits
			if (check) {
				for (int i = 0; i < id_mod_str.length; i++) {
					int id_mod = Integer.parseInt(id_mod_str[i]);
					int quantite_mod = Integer.parseInt(quantite_mod_str[i]);
					float prix_mod = Float.parseFloat(prix_mod_str[i]);
					
					try {
						statement.executeUpdate("UPDATE produits.produits SET nom='" + titre_mod[i] + "' WHERE id = '" + id_mod + "';");
						statement.executeUpdate("UPDATE produits.produits SET prix='" + prix_mod + "' WHERE id = '" + id_mod + "';");
						statement.executeUpdate("UPDATE produits.produits SET quantite='" + quantite_mod + "' WHERE id = '" + id_mod + "';");
						statement.executeUpdate("UPDATE produits.produits SET description='" + description_mod[i] + "' WHERE id = '" + id_mod + "';");
					} catch (SQLException e) {
						System.out.println("erreur2 : " + e.getMessage());
					}
				}
			}
			
		// si on a cliqué sur SUPPRIMER
		} else if (supprimer.equals("true")) {
			try {
				statement.executeUpdate("DELETE FROM produits.produits WHERE id="+id+";");
			} catch (SQLException e) {
				System.out.println("erreur2 : " + e.getMessage());
			}
		}
		
		// on récupère la liste des produits
		try {
			resultat = statement.executeQuery("SELECT * FROM PRODUITS");
			// aussi executeUpdate pour faire un changement dans la BDD
			
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				int quantite = resultat.getInt("quantite");
				float prix = resultat.getFloat("prix");
				String description = resultat.getString("description");
				int id_list = resultat.getInt("id");
				
				Produit produit = new Produit();
				produit.setId(id_list);
				produit.setTitre(nom);
				produit.setQuantite(quantite);
				produit.setPrix(prix);
				produit.setDescription(description);
				
				listeBillets.add(produit);
			}
			
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
		
		return "gestion";
	}
}
