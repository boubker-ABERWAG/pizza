<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="modifier_pizza" method="POST">
		<label for="libelle">Libelle: </label>
			<input type="text" name="libelle" placeholder="Libelle" id="libelle" value="${pizza.libelle }"/><br/>
		<label for="reference">Reference: </label>
			<input type="text" name="reference" placeholder="reference" id="reference" value="${pizza.reference }"/><br/>
		<label for="prix">Prix: </label>
			<input type="text" name="prix" placeholder="prix" id="prix" value="${pizza.prix }"/><br/>
		<label for="url">URL: </label>
			<input type="text" name="url" placeholder="url" id="url" value="${pizza.urlImage }"/><br/>
			<input hidden type="text" name="id" placeholder="ID" id="id" value="${pizza.id }"/>
		<input type="submit" value="Valider"/>
	</form> 

</body>
</html>