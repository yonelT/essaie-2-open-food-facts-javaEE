package fr.diginamic.controllers;

import java.io.IOException;
import java.sql.SQLException;
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
public class ControlleurProduits extends HttpServlet {
		@Override
		public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			List<Produit> listProduits = new ArrayList<Produit>();
			ProduitDao produitDao = new ProduitDao();
			
			try {
				listProduits = produitDao.getListProduits();
			} catch (SQLException e) {
				e.printStackTrace(); // TODO Auto-generated catch block
			}
			req.setAttribute("listeDeProduits", listProduits);

//			@@@@ Deprecated	@@@@
//			Si on fait du HTML dans du Java
//			for (int i = 0; i < listProduits.size() ; i++){
//				resp.getWriter().write("<h1>" + listProduits.get(i).getCategorie() + "</h1>");
//			}
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/produits.jsp");
			requestDispatcher.forward(req, resp);
		}
}
