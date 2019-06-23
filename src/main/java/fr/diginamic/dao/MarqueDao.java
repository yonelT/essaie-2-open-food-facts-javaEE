package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.model.Marque;

public class MarqueDao {
	
	Connection maConnexion = null;
	Statement statement = null;
	ResultSet curseur = null;
	
	public List<Marque> getMarque(){
		
		List<Marque> listeDeMarque = new ArrayList<Marque>();
		
		ResourceBundle monFichierDeConf = ResourceBundle.getBundle("connexionDB");
		String url = monFichierDeConf.getString("connexionDB.url");
		String user = monFichierDeConf.getString("connexionDB.user");
		String password = monFichierDeConf.getString("connexionDB.password");
		String query = null;
		
		int idMarqueCourante = 0;
		String nomMarqueCourante = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			maConnexion = DriverManager.getConnection(url,user,password);
			
			statement = maConnexion.createStatement();
			
			query = "select marques.id as ID_MARQUE, marques.nom as NOM_MARQUE from marques order by ID_MARQUE;";
			curseur = statement.executeQuery(query);
			
			while(curseur.next()) {
				idMarqueCourante = curseur.getInt("ID_MARQUE");
				nomMarqueCourante = curseur.getString("NOM_MARQUE");
				listeDeMarque.add(new Marque(idMarqueCourante,nomMarqueCourante));
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		}
		
		return listeDeMarque;
	}

}
