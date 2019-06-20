package fr.diginamic.model;

/**
 * @author Yonel
 * Class définissant une Catégorie
 */
public class Categorie {
	
	/**
	 * Déclaration des variables de la table SQL categories
	 */
	private int id = 0;
	private String nom = null;

	/**
	 * Déclaration du constructeur par défaut
	 */
	public Categorie(){
		
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

}
