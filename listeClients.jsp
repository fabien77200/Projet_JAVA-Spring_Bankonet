<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title><spring:message code="page.home.title" /></title>
</head>
<body>

	<a href="<%=request.getContextPath()%>/home">vers HomeController</a>
	********


	<ul id="nav">
		<li id="nav-home"><a href="?lang=fr">France</a></li>
		<li id="nav-about"><a href="?lang=en">England</a></li>
	</ul>


	<span style="float: right"> <a href="?lang=fr">fr</a> | <a
		href="?lang=en">en</a>
	</span>

	<h4>
		<spring:message code="page.home.hello" />
	</h4>


	<h3>Formulaire vers Base de données :</h3>

	<form:form method="POST" action="/spring/saveClient"
		modelAttribute="client">
		<table>
			<tr>
				<td><form:label path="id">ID</form:label></td>
				<td><form:input path="id" /></td>
				<td><form:errors path="id"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="prenom">Prenom</form:label></td>
				<td><form:input path="prenom" /></td>
				<td><form:errors path="prenom"></form:errors></td>
			</tr>
			<tr>

				<td><form:label path="nom">Nom</form:label></td>
				<td><form:input path="nom" /></td>
				<td><form:errors path="nom"></form:errors></td>
			</tr>
			<tr>

				<td><form:label path="login">Login</form:label></td>
				<td><form:input path="login" /></td>
				<td><form:errors path="login"></form:errors></td>
			</tr>
			<tr>

				<td><form:label path="motDePasse">password</form:label></td>
				<td><form:input path="motDePasse" /></td>
				<td><form:errors path="motDePasse"></form:errors></td>
			</tr>
			
		</table>

		<input type="submit" value="Enregistrer" />
	</form:form>
	
	

	<hr>
	<h2>Liste des clients :</h2>

	<table cellspacing="2px" cellpadding="2px;" rules="all"
		style="border: solid 1px black;">

		<tr>

			<th>ID</th>
				<th>
				PRENOM
			</th>
				<th>NOM
			</th>
				<th>Update
			</th>
				<th>Delete
			</th>	
			
			</tr>


		<c:forEach items="${listClients}" var="client">



					<tr>
				<td>${client.id}</td>
				<td>${client.nom}</td>
				<td>${client.prenom}</td>
				<td><a href="/spring/editClient/${client.id}"> Update </a></td>
				<td><a href="/spring/deleteClient?id=${client.id}">Delete </a></td>			
			</tr>

		</c:forEach>

	
			</table>

</body>
</html>
