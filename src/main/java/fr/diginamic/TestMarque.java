package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.dao.MarqueDao;
import fr.diginamic.model.Marque;

public class TestMarque {

	public static void main(String[] args) {
		MarqueDao marqueDao = new MarqueDao();
		List<Marque> listMarque = new ArrayList<Marque>();
		listMarque = marqueDao.getMarque();
		
		System.out.println("Liste des marques \"forEach\"");
		for (Marque marq : listMarque) {
			System.out.println("Id: " + marq.getId() + " | " + "Nom: " + marq.getNom());
		}

	}

}
