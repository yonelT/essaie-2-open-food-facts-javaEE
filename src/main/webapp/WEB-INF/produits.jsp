<%@ page language="java" pageEncoding="utf8"%>
<%@page import="java.util.List, fr.diginamic.model.Produit"%>

<%-- INCLURE LA NAVBAR FIXE --%>
<%@include file="navbar.jsp"%>


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

<title>Produits Open Food Facts</title>

</head>

<body>
	<div class="mt-2">""</div>
	<div class="container mt-5">
	<h2 class="text-center">Liste des produits</h2>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Liste des
							ingrédients</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<%--          <% List<Ingredient> listIngredients = (List<Ingredient>) request.getAttribute("listeDeIngredients"); --%>

						// for (int i = 0; i < listIngredients.size() ; i++){
						<%-- 		%> --%>
						<%-- 			<%=listIngredients.get(i).getCategorie()%> --%>
						<%-- 		<% } %>  --%>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id.</th>
					<th scope="col">Catégorie</th>
					<th scope="col">Marque</th>
					<th scope="col">Nom</th>
					<th scope="col">Grade</th>
					<th scope="col">Energie</th>
					<th scope="col">Graisse</th>
				</tr>
			</thead>
			<tbody>
				<!--  /!\ /!\  Attention, si on récupère un req dans une JSP ca s'appel "request" obligatoirement maintenant /!\ /!\ -->
				<%
					List<Produit> listProduits = (List<Produit>) request.getAttribute("listeDeProduits");

					for (int i = 0; i < listProduits.size(); i++) {
				%>
				<tr>
					<th scope="row"><%=listProduits.get(i).getId()%></th>
					<td><%=listProduits.get(i).getCategorie()%></td>
					<td><%=listProduits.get(i).getMarque()%></td>
					<td><a href="" data-toggle="modal" data-target="#exampleModal"><%=listProduits.get(i).getNom()%></a></td>
					<td><%=listProduits.get(i).getGrade()%></td>
					<td><%=listProduits.get(i).getEnergie()%></td>
					<td><%=listProduits.get(i).getGraisse()%></td>
				</tr>
				<%
					}
				%>
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