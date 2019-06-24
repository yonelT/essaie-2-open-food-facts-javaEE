package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class Produit {
	
	private int id = 0;
	private String categorie = null;
	private String marque = null;
	private String nom = null;
	private String grade = null;
	private String energie = null;
	private String graisse = null;
	private List<String> listeDingredients = new ArrayList<String>(); 
	
	//Unused variables
	private String fibres = null;
	private String pays = null;
	private String paysManufact = null;
	private String proteines = null;
	private String sel = null;
	private String sucre = null;
	
	public Produit() {
		super();
	}

	public Produit(int id, String categorie, String marque, String nomProduit, String grade, String energie,  String graisse, List<String> listeDingredients) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.marque = marque;
		this.nom = nomProduit;
		this.grade = grade;
		this.energie = energie;
		this.graisse = graisse;
		this.listeDingredients = listeDingredients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	public String getFibres() {
		return fibres;
	}

	public void setFibres(String fibres) {
		this.fibres = fibres;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGraisse() {
		return graisse;
	}

	public void setGraisse(String graisse) {
		this.graisse = graisse;
	}
	
	public List<String> getListeDingredients() {
		return listeDingredients;
	}

	public void setListeDingredients(List<String> listeDingredients) {
		this.listeDingredients = listeDingredients;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getPaysManufact() {
		return paysManufact;
	}

	public void setPaysManufact(String paysManufact) {
		this.paysManufact = paysManufact;
	}

	public String getProteines() {
		return proteines;
	}

	public void setProteines(String proteines) {
		this.proteines = proteines;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getSucre() {
		return sucre;
	}

	public void setSucre(String sucre) {
		this.sucre = sucre;
	}
	
}
