<%@ page language="java" pageEncoding="utf8"%>
<%@page import="java.util.List, fr.diginamic.model.Marque"%>

<%-- INCLURE LA NAVBAR FIXE --%>
<%@include file="navbar.jsp"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Marques Open Food Facts</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="mt-2">""</div>
	<div class="container mt-5">
		<h2 class="text-center">Liste des marques
				<div class="row flex-row-reverse mr-5 ">
			<input type="button" id="maModal" class="btn btn-success" data-toggle="modal" data-target="#exampleModal2"
				value="Ajouter une marque">
		</div>
		</h2>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ajouter une
							catégorie</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form method="POST" action="/openff/marques">
							<div class="form-group">

								<label for="identifiant">Identifiant</label> <input type="text"
									class="form-group" id="id" name="id" placeholder="identifiant">
							</div>
							<div>
								<label for="nomCategorie">Nom categorie</label> <input
									type="text" class="form-group" id="nomCat" name="nomCat"
									placeholder="Nom categorie">
							</div>
							<input type="submit" id="soumettre" name="soumettre">
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save changes</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nom</th>
				</tr>
			</thead>

			<%
				List<Marque> listeDesMarques = (List<Marque>) request.getAttribute("marques");

				for (int i = 0; i < listeDesMarques.size(); i++) {
			%>
			<tbody>
				<tr>
					<th scope="row"><%=listeDesMarques.get(i).getId()%></th>
					<td><%=listeDesMarques.get(i).getNom()%></td>
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