<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td,tr,th,table{
border: green 2px solid;
border-collapse: collapse;
}
</style>
</head>
<body>
<table>
<tr>
	<th>ID</th>
	<th>Libelle</th>
	<th>Reference</th>
	<th>PRIX</th>
	<th>URL</th>
</tr>



	<c:forEach items="${listePizza }" var="pizza">
		<tr>
			<td>${pizza.id }</td>
			<td>${pizza.libelle }</td>
			<td>${pizza.reference }</td>
			<td>${pizza.prix }</td>
			<td>${pizza.urlImage }</td>
			<td><a href="modifier_pizza?id=${pizza.id}">Modifier</a></td>
		</tr>
	</c:forEach>
</table>

<a href="ajout_pizza">AJouter une Pizza</a>
</body>
</html>