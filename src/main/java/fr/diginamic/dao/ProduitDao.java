package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.model.Produit;

public class ProduitDao {

	static List<Produit> maListeDeProduits = new ArrayList<Produit>();
	
	public List<Produit> getListProduits() throws SQLException {
		
		List<Produit> listProduits = new ArrayList<Produit>();
		
		//Elements de connexion à la DB openfoodfacts
		ResourceBundle monFichierDeConf = ResourceBundle.getBundle("authentication");
		String driverName = monFichierDeConf.getString("authentication.driver");
		String url = monFichierDeConf.getString("authentication.url");
		String user = monFichierDeConf.getString("authentication.user");
		String password = monFichierDeConf.getString("authentication.password");
		
		// Déclaration de la Connection puis du Statement et d'un ResultSet
		Connection connexionBase = null;
		Statement statement = null;
		ResultSet curseur = null;
		
		//Déclaration des variables du produit courant
		String categorieProduitCourant = null;
		String marqueProduitCourant = null;
		String nomProduitCourant = null;
		String gradeProduitCourant = null;
		String energieProduitCourant = null;
		String graisseProduitCourant = null;

		// Chargement du driver MySQL
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
		
		//Connexion à la DB
		connexionBase = DriverManager.getConnection(url, user, password);
		
		//Initialisation du Statement permettant de générer les requetes SQL à la DB
		statement = connexionBase.createStatement();

		// Requête permettant de rechercher des produits selon les critères
		// suivants : catégorie, marque, nom, grade nutritionnel, énergie,
		// graisse pour 100 produits
		curseur = statement.executeQuery(
				"SELECT categories.nom AS \"CATEGORIE\", marques.nom AS \"MARQUE\", produits.nom AS \"PRODUIT\", produits.grade AS \"GRADE NUTRITIONNEL\", produits.energie AS \"ENERGIE\", produits.graisse AS \"GRAISSE\" FROM produits, categories, marques WHERE produits.id_cat=categories.id AND produits.id_mrq=marques.id LIMIT 100;");
		
		//"while" qui parcour chaque ligne du curseur, chaque ligne étant un produit différent
		while (curseur.next()) {
			categorieProduitCourant = curseur.getString("CATEGORIE");
			marqueProduitCourant = curseur.getString("MARQUE");
			nomProduitCourant = curseur.getString("PRODUIT");
			gradeProduitCourant = curseur.getString("GRADE NUTRITIONNEL");
			energieProduitCourant = curseur.getString("ENERGIE");
			graisseProduitCourant = curseur.getString("GRAISSE");
			
			//ajoute une ligne (un produit) à une liste de produits
			listProduits.add(new Produit(categorieProduitCourant, marqueProduitCourant, nomProduitCourant, gradeProduitCourant, energieProduitCourant, graisseProduitCourant));
		}
		return listProduits;
	}
	
	
	//Main pour tester la méthode getListProduits()
	public static void main(String[] args) throws SQLException{
		ProduitDao prdDao = new ProduitDao();
		
		maListeDeProduits = prdDao.getListProduits();
		
		for (Produit produit : maListeDeProduits){
			System.out.println("CATEGORIE: " + produit.getCategorie() + " | MARQUE: " + produit.getMarque() + " | NOM: " + produit.getNom() + " | GRADE: " + produit.getGrade() + " | ENERGIE: " + produit.getEnergie() + " | GRAISSE: " + produit.getGraisse());
		}
	}
}
