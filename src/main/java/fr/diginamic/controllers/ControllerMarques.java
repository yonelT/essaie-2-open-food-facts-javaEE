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

import fr.diginamic.dao.MarqueDao;
import fr.diginamic.model.Marque;

@WebServlet(urlPatterns = "/marques/*")
public class ControllerMarques extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MarqueDao marqueDao = new MarqueDao();
		List<Marque> ListMarque = new ArrayList<Marque>();
		ListMarque = marqueDao.getMarque();
		
		req.setAttribute("marques", ListMarque);
		
		//le dispatcher permet de garder les info en internes (req et resp) ; attention les redirect servent a rediriger vers des pages plutot externes pckelle ne gardent aucune données
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/marques.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int newId = Integer.parseInt(req.getParameter("id"));
		String newNomCat = req.getParameter("nomCat");
		
		//Marque newMarque = new Marque(newId,newNomCat);
		MarqueDao marqueDao = new MarqueDao();
		
		marqueDao.ajouterMarque(newId, newNomCat);
		List<Marque> ListMarque = new ArrayList<Marque>();
		
ListMarque = marqueDao.getMarque();
		
		req.setAttribute("marques", ListMarque);
		
		
		//le dispatcher permet de garder les info en internes (req et resp) ; attention les redirect servent a rediriger vers des pages plutot externes pckelle ne gardent aucune donnée
		//resp.sendRedirect("/openff/marques2");
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/marques.jsp");
		dispatcher.forward(req, resp);

	}
}