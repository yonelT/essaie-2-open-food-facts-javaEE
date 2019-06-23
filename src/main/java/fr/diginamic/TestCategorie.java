package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.dao.CategorieDao;
import fr.diginamic.model.Categorie;

public class TestCategorie {
	
	public static void main(String[] args) {
		
		CategorieDao categorieDao = new CategorieDao();
		List<Categorie> listCat = new ArrayList<Categorie>();
		listCat = categorieDao.getCategories();
		
		System.out.println("Liste des cat�gories \"forEach\"");
		for (Categorie cat : listCat) {
			System.out.println("Id: " + cat.getId() + " | " + "Nom: " + cat.getNom());
		}
		
		System.out.println("\n\nListe des cat�gories \"for standard\"");
		for (int i=0; i < listCat.size(); i++) {
			System.out.println("Id: " + listCat.get(i).getId() + " | " + "Nom: " + listCat.get(i).getNom());
		}
	}

}
