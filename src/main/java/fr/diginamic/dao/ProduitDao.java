package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ProduitDao {
	
	// Déclaration de la connection puis du Statement et d'un ResultSet
	Connection connexionBase = null;
	Statement statement = null;
	ResultSet curseur = null;
	
	public ResultSet connexionTableProduit() throws SQLException{
		ResourceBundle monFichierDeConf = ResourceBundle.getBundle("authentication");
		String driverName = monFichierDeConf.getString("authentication.driver");
		String url = monFichierDeConf.getString("authentication.url");
		String user = monFichierDeConf.getString("authentication.user");
		String password = monFichierDeConf.getString("authentication.password");
		
		//Chargement du driver MySQL
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
		
		connexionBase = DriverManager.getConnection(url, user, password);
		
		statement = connexionBase.createStatement();
		
		//Requête permettant de rechercher des produits selon les critères suivants : catégorie, marque, nom, grade nutritionnel, énergie, graisse pour 100 produits
		curseur = statement.executeQuery("SELECT categories.nom AS \"CATEGORIE\", marques.nom AS \"MARQUE\", produits.nom AS \"PRODUIT\", produits.grade AS \"GRADE NUTRITIONNEL\", produits.energie AS \"ENERGIE\", produits.graisse AS \"GRAISSE\" FROM produits, categories, marques WHERE produits.id_cat=categories.id AND produits.id_mrq=marques.id LIMIT 100;");
		
		return curseur;
	}
	
	public static void main(String[] args){
		try {
			ProduitDao prdao = new ProduitDao();
			ResultSet test = prdao.connexionTableProduit();
			while(test.next()){
				System.out.println(test.getString("CATEGORIE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
