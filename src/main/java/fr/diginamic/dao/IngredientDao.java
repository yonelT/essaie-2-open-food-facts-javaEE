package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.model.Ingredient;
import fr.diginamic.model.Marque;

public class IngredientDao {
	Connection maConnexion = null;
	Statement statement = null;
	ResultSet curseur = null;
	
	public List<String> getIngredient(){
		
		List<String> listIngredients = new ArrayList<String>();
		
		ResourceBundle monFichierDeConf = ResourceBundle.getBundle("connexionDB");
		String url = monFichierDeConf.getString("connexionDB.url");
		String user = monFichierDeConf.getString("connexionDB.user");
		String password = monFichierDeConf.getString("connexionDB.password");
		String query = null;
		
		String nomProduit = null;
		String nomIngredient = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			maConnexion = DriverManager.getConnection(url,user,password);
			
			statement = maConnexion.createStatement();
			
			query = "select produits.nom as PRODUIT, ingredients.nom as INGREDIENTS from ingredients, produits_ing, produits where produits.id=produits_ing.id_prd and ingredients.id=produits_ing.id_ing order by produits.id;";
			curseur = statement.executeQuery(query);
	
			String nomProduitCourant = "Fromage basilic & pignons de pin 10 x 16 g";
			
			while(curseur.next()) {
				nomProduit = curseur.getString("PRODUIT");
				nomIngredient = curseur.getString("INGREDIENTS");
				while(nomProduitCourant.equals(nomProduit)) {
				
				listIngredients.add("INGREDIENTS");
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
		
		return listIngredients;
	}
}
