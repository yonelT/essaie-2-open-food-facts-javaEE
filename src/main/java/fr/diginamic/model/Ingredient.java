package fr.diginamic.model;

public class Ingredient {
	
	private int id = 0;
	private String nom = null;
	private String nomProduit = null;
	
	public Ingredient() {
		super();
	}

	public Ingredient(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Ingredient(String nomProduit, String nom) {
		super();
		this.nomProduit = nomProduit;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
}
