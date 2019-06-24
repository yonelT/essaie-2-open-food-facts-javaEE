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
	
	Connection connexion = null;
	Connection connexion2 = null;
	Statement instruction = null;
	Statement instruction2 = null;
	ResultSet curseur = null;
	ResultSet curseur2 = null;
	
	ResourceBundle monFichierDeConf = ResourceBundle.getBundle("connexionDB");
	String url = monFichierDeConf.getString("connexionDB.url");
	String user = monFichierDeConf.getString("connexionDB.user");
	String password = monFichierDeConf.getString("connexionDB.password");
	String query = null;
	String query2 = null;
	
	public List<Produit> getProduits() {
		
		List<Produit> listeDeProduits = new ArrayList<Produit>();
		List<String> listIngredients = new ArrayList<String>();
		
		int idProduitCourant = 0;
		String categorieProduitCourant = null;
		String marqueProduitCourant = null;
		String nomProduitCourant = null;
		String gradeProduitCourant = null;
		String energieProduitCourant = null;
		String graisseProduitCourant = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			connexion = DriverManager.getConnection(url, user, password);
			connexion2 = DriverManager.getConnection(url, user, password);
			
			instruction = connexion.createStatement();
			instruction2 = connexion2.createStatement();
			
			query = "select produits.id as ID_PRODUIT, categories.nom as CATEGORIE, marques.nom as MARQUE, produits.nom as NOM_PRODUIT, produits.grade as GRADE, produits.energie as ENERGIE, produits.graisse as GRAISSE from categories, marques, produits where categories.id=produits.id_cat and marques.id=produits.id_mrq limit 100;";
			curseur = instruction.executeQuery(query);
			
			int idProduitIng = 1;
			query2 = "select produits.id as ID_PRODUIT_ING, ingredients.nom as NOM_INGREDIENT from ingredients, produits_ing, produits where produits.id=produits_ing.id_prd and ingredients.id=produits_ing.id_ing order by produits.id;";
			curseur2 = instruction2.executeQuery(query2);
			
			idProduitIng = curseur2.getInt("ID_PRODUIT_ING");
			
			while(curseur.next()) {
				idProduitCourant = curseur.getInt("ID_PRODUIT");
				categorieProduitCourant = curseur.getString("CATEGORIE");
				marqueProduitCourant = curseur.getString("MARQUE");
				nomProduitCourant = curseur.getString("NOM_PRODUIT");
				gradeProduitCourant = curseur.getString("GRADE");
				energieProduitCourant = curseur.getString("ENERGIE");
				graisseProduitCourant = curseur.getString("GRAISSE");
				
				while(idProduitCourant == idProduitIng) {
					listIngredients.add(curseur2.getString("NOM_INGREDIENT"));
				}
								
				Produit produitCourant = new Produit(idProduitCourant,categorieProduitCourant,marqueProduitCourant,nomProduitCourant,gradeProduitCourant,energieProduitCourant,graisseProduitCourant,listIngredients); 
				listeDeProduits.add(produitCourant);
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
		
		return listeDeProduits;
	}
	

}
