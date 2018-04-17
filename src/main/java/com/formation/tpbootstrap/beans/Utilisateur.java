package com.formation.tpbootstrap.beans;

// classe représentant un utilisateur du site
public class Utilisateur {
	
	String nom = "";
	String prenom = "";
	String email = "";
	String dateNaissance = "";
	String login = "";
	String mdp = "";
	String sexe = "";
	
	public Utilisateur(String nom, String prenom, String email, String dateNaissance, String login, String mdp,
			String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.login = login;
		this.mdp = mdp;
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
}
