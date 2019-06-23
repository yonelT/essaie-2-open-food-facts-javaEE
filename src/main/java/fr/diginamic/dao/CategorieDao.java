package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.model.Categorie;

public class CategorieDao {
	
	Connection maConnexion = null;
	Statement statement = null;
	ResultSet curseur = null;
	
	public List<Categorie> getCategories(){
		
	List<Categorie> listeDeCategories = new ArrayList<>();
	
	ResourceBundle monFichierDeConf = ResourceBundle.getBundle("connexionDB");
	String url = monFichierDeConf.getString("connexionDB.url");
	String user = monFichierDeConf.getString("connexionDB.user");
	String password = monFichierDeConf.getString("connexionDB.password");
	String query = null;
	
	int idCategorieCourante = 0;
	String nomCategorieCourante = null;
	
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
		Connection maConnexion = DriverManager.getConnection(url, user, password);
		
		statement = maConnexion.createStatement();
		
		query = "select categories.id as ID, categories.nom as NOM from categories;";
		curseur = statement.executeQuery(query);
		
		while(curseur.next()) {
			idCategorieCourante = curseur.getInt("ID");
			nomCategorieCourante = curseur.getString("NOM");
			listeDeCategories.add(new Categorie(idCategorieCourante,nomCategorieCourante));
		}
		
	} catch (SQLException e) {
		e.printStackTrace(); // TODO Auto-generated catch block
	}
	
	return listeDeCategories;
	}	
}
