package fr.diginamic.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.diginamic.dao.ProduitDao;
import fr.diginamic.model.Produit;

@WebServlet(urlPatterns = "/produits/*")
public class ControllerProduits extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProduitDao produitDao = new ProduitDao();
		List<Produit> listProduit = new ArrayList<Produit>();
		listProduit = produitDao.getProduits();
		
		req.setAttribute("listeDeProduits", listProduit);
		//req.setAttribute("listeDingredients", listIngredients);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/produits.jsp");
		dispatcher.forward(req, resp);
	}
}
