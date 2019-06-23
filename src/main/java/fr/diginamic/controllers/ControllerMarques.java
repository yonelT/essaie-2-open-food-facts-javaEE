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
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/marques.jsp");
		dispatcher.forward(req, resp);
	}
}