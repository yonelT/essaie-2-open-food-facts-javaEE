package fr.diginamic.model;

/**
 * @author Yonel
 * Class définissant un produit
 */
public class Produit {
	
	/**
	 * Déclaration des variables de la table Produit
	 */
	private int id = 0;
	private String energie = null;
	private String fibres = null;
	private String grade = null;
	private String graisse = null;
	private String nom = null;
	private String pays = null;
	private String paysManufact = null;
	private String proteines = null;
	private String sel = null;
	private String sucre = null;
	private String categorie = null;
	private String marque = null;
	
	
	/**
	 * Déclaration du constructeur par défaut
	 */
	public Produit(){
		
	}
	
	/**
	 * Constructeur du premier besoin utilisateur
	 */
	public Produit(String categorie, String marque, String nom, String grade, String energie, String graisse){

		this.categorie = categorie;
		this.marque = marque;
		this.nom = nom;
		this.grade = grade;
		this.energie = energie;
		this.graisse = graisse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
