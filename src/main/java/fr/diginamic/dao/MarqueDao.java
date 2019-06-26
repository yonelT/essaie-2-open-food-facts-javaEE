package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.exception.TechnicalException;
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
		} finally {
			try {
				// fermeture des ResultSet
				if (curseur != null) {
					curseur.close();
				}

				// Fermeture des Statements
				if (statement != null) {
					statement.close();
				}

				// fermeture de la connexion JDBC
				if (maConnexion != null) {
					maConnexion.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("La déconnexion à la base a échoué");
			}
		}
		
		return listeDeMarque;
	}
	
	
public void ajouterMarque(int idNewMarque, String nomNewMarque){
				
		ResourceBundle monFichierDeConf = ResourceBundle.getBundle("connexionDB");
		String url = monFichierDeConf.getString("connexionDB.url");
		String user = monFichierDeConf.getString("connexionDB.user");
		String password = monFichierDeConf.getString("connexionDB.password");
		String query = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			maConnexion = DriverManager.getConnection(url,user,password);
			
			maConnexion.setAutoCommit(false);
			
			statement = maConnexion.createStatement();
			
			query = "INSERT INTO MARQUES (marques.id,marques.nom) VALUES (\"" + idNewMarque +"\",\"" + nomNewMarque +"\");";
			statement.executeUpdate(query);

			maConnexion.commit();
			
		} catch (SQLException e) {
			e.printStackTrace(); // TODO Auto-generated catch block
		} finally {
			try {
				// fermeture des ResultSet
				if (curseur != null) {
					curseur.close();
				}

				// Fermeture des Statements
				if (statement != null) {
					statement.close();
				}

				// fermeture de la connexion JDBC
				if (maConnexion != null) {
					maConnexion.close();
				}
			} catch (SQLException e) {
				throw new TechnicalException("La déconnexion à la base a échoué");
			}
		}
	}

}
