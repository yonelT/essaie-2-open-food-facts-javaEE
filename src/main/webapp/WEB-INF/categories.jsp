<%@ page language="java" pageEncoding="utf8"%>
<%@page import="java.util.List, fr.diginamic.model.Categorie"%>
<%-- INCLURE LA NAVBAR FIXE --%>
<%@include file="navbar.jsp"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Categories Open Food Facts</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="mt-2">""</div>
	<div class="container mt-5">
		<h2 class="text-center">Liste des catégories</h2>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nom</th>
				</tr>
			</thead>
			
			<% List<Categorie> listeDesCategories = (List<Categorie>) request.getAttribute("categories");
			
			for (int i=0; i < listeDesCategories.size(); i++) {
			
			%>
			<tbody>
				<tr>
					<th scope="row"><%=listeDesCategories.get(i).getId()%></th>
					<td><%=listeDesCategories.get(i).getNom()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>