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

import fr.diginamic.dao.CategorieDao;
import fr.diginamic.model.Categorie;

@WebServlet(urlPatterns = "/categories/*")
public class ControllerCategories extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CategorieDao categorieDao = new CategorieDao();
		List<Categorie> ListCat = new ArrayList<Categorie>();
		ListCat = categorieDao.getCategories();
		
		req.setAttribute("categories", ListCat);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp");
		dispatcher.forward(req, resp);
	}
}