<%@ page language="java" pageEncoding="utf8"%>
<%@page import="java.util.List, fr.diginamic.model.Produit"%>

<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- DEPENDENCES CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="..\style.css">

<title>Open Food Facts</title>

</head>

<body>
	<h1>Liste des produits</h1>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Catégorie</th>
				<th scope="col">Marque</th>
				<th scope="col">Nom</th>
				<th scope="col">Grade Nutritionnel</th>
				<th scope="col">Energie</th>
				<th scope="col">Graisse</th>
			</tr>
		</thead>
		<tbody>
		<!--  /!\ /!\  Attention, si on récupère un req dans une JSP ca s'appel "request" obligatoirement maintenant /!\ /!\ -->
		<% List<Produit> listProduits = (List<Produit>) request.getAttribute("listeDeProduits");
						
		for (int i = 0; i < listProduits.size() ; i++){
		%>
			<tr>
				<td><%=listProduits.get(i).getCategorie()%> </td>
				<td><%=listProduits.get(i).getMarque()%> </td>
				<td><%=listProduits.get(i).getNom()%> </td>
				<td><%=listProduits.get(i).getGrade()%> </td>
				<td><%=listProduits.get(i).getEnergie()%> </td>
				<td><%=listProduits.get(i).getGraisse()%> </td>
			</tr>
		<% } %>
		</tbody>
	</table>

</body>
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
</html>
