package com.formation.tpbootstrap.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.tpbootstrap.beans.Produit;
import com.formation.tpbootstrap.beans.Utilisateur;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginGet(final ModelMap pModel) {
		
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String loginPost(final ModelMap pModel, @RequestParam(value="LOGIN", defaultValue="") final String login,
			@RequestParam(value="MDP", defaultValue="") final String mdp, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String url = "jdbc:mysql://127.0.0.1:3306/produits?useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root = "root";
		String mdp_mysql = "Pass123!";
		
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		
		pModel.addAttribute("BADREQUEST", "true");
		boolean connected = false;
		
		try {
			// connexion à la BDD
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, root, mdp_mysql);
			statement = connexion.createStatement();
			
			// on récupère la liste des utilisateurs
			resultat = statement.executeQuery("SELECT * FROM UTILISATEURS");
			while(resultat.next()) {
				if (login.equals(resultat.getString("login")) && mdp.equals(resultat.getString("mdp"))) {
					pModel.addAttribute("BADREQUEST", "false");
					session.setAttribute("user", login);
					connected = true;
					Utilisateur user = new Utilisateur(resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("email"),
							resultat.getString("date_naissance"), resultat.getString("login"), resultat.getString("mdp"), resultat.getString("sexe"));
					session.setAttribute("utilisateur", user);
				}
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
		
		// si c'est pas des bons identifiants, on déconnecte
		if (connected == false ) {
			session.invalidate();
		}
		
		return "login";
	}
	
}
