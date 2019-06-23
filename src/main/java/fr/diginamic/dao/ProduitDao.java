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
	Statement instruction = null;
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
			
			instruction = connexion.createStatement();
			
			query = "select produits.id as ID_PRODUIT, categories.nom as CATEGORIE, marques.nom as MARQUE, produits.nom as NOM_PRODUIT, produits.grade as GRADE, produits.energie as ENERGIE, produits.graisse as GRAISSE from categories, marques, produits where categories.id=produits.id_cat and marques.id=produits.id_mrq limit 100;";
			curseur = instruction.executeQuery(query);
			
//			query2 = "select produits.nom as PRODUIT, ingredients.nom as INGREDIENTS from ingredients, produits_ing, produits where produits.id=produits_ing.id_prd and ingredients.id=produits_ing.id_ing order by produits.id;";
//			curseur2 = instruction.executeQuery(query2);
//	
//			String nomProduitCourant2 = "Fromage basilic & pignons de pin 10 x 16 g";
//			String nomProduit =null;
//			
//			String nomIngredient=null;
//			
			
			while(curseur.next()) {
				idProduitCourant = curseur.getInt("ID_PRODUIT");
				categorieProduitCourant = curseur.getString("CATEGORIE");
				marqueProduitCourant = curseur.getString("MARQUE");
				nomProduitCourant = curseur.getString("NOM_PRODUIT");
				gradeProduitCourant = curseur.getString("GRADE");
				energieProduitCourant = curseur.getString("ENERGIE");
				graisseProduitCourant = curseur.getString("GRAISSE");
				
//				curseur2.next();
//					nomProduit = curseur2.getString("PRODUIT");
//					nomIngredient = curseur2.getString("INGREDIENTS");
//					while(nomProduitCourant.equals(nomProduit)) {
//
//					listIngredients.add("INGREDIENTS");
//					
//				}
				
				Produit produitCourant = new Produit(idProduitCourant,categorieProduitCourant,marqueProduitCourant,nomProduitCourant,gradeProduitCourant,energieProduitCourant,graisseProduitCourant); 
				listeDeProduits.add(produitCourant);
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
		
		return listeDeProduits;
	}
	

}
