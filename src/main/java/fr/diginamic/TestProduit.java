package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.dao.ProduitDao;
import fr.diginamic.model.Produit;

public class TestProduit {

	public static void main(String[] args) {
		
		ProduitDao produitDao = new ProduitDao();
		List<Produit> listProduit = new ArrayList<Produit>();
		listProduit = produitDao.getProduits();
		
		System.out.println("Liste des produits \"forEach\"");
		for (Produit produit : listProduit) {
			System.out.println("Id: " + produit.getId() + " | " + "Nom: " + produit.getNom() + " | " + "Ingrédients:" + produit.getListeDingredients());
		}

	}

}
