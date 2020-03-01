<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>



	<form:form action="insert" method="post" modelAttribute="person">
		<span>La pokeball activa es <c:out value="${person.pokeball.name}" /></span>
	</form:form>
	<br />
	<br />
	<br />
	
	
	<form:form action="insertPokemonFriend" method="post" modelAttribute="person">
		<span>nuevo Pokemone aliado:</span>
		<span>nombre:</span>
		<form:input type="text" path="pokemon.name" />
		<span>vida:</span>
		<form:input type="text" path="pokemon.hp" />
		<span>ataque:</span>
		<form:input type="text" path="pokemon.attack" />
		<input type="submit" value="Añadir pokemon" />
	</form:form>
	<br />
	<br />
	<br />
	
	<form:form action="insertWildPokemon" method="post" modelAttribute="rival">
		<span>nuevo Pokemone salvaje</span>
		<span>nombre:</span>
		<form:input type="text" path="pokemon.name" />
		<span>vida:</span>
		<form:input type="text" path="pokemon.hp" />
		<span>ataque:</span>
		<form:input type="text" path="pokemon.attack" />
		<input type="submit" value="Añadir pokemon" />
	</form:form>
	<br />
	<br />
	<br />
	<br /> El pokemon activo es
	<span><c:out value="${person.pokeActive.name}" /></span>.
	<br />
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>hp</td>
				<td>ataque</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pokemons" items="${person.pokemons}">
				<tr>
					<td><c:out value="${pokemons.name}" /></td>
					<td><c:out value="${pokemons.hp}" /></td>
					<td><c:out value="${pokemons.attack}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<br />
	<br />
	<span><c:out value="Pokemones Capturados" /></span>
	<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>hp</td>
				<td>ataque</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pokemonsCaptured" items="${person.pokemonsCaptured}">
				<tr>
					<td><c:out value="${pokemonsCaptured.name}" /></td>
					<td><c:out value="${pokemonsCaptured.hp}" /></td>
					<td><c:out value="${pokemonsCaptured.attack}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<br />
	<br />
	<form:form action="switchPokemon" method="post">
		<input type="submit" value="cambiar de esclavo" />
	</form:form>
	<br />
	<br />
	<br />
	<br /> El pokemon salvaje es
	<span><c:out value="${rival.pokemon.name}" /></span>
	 tiene <span><c:out value="${rival.pokemon.hp}" /></span> de vida y
	 <span><c:out value="${rival.pokemon.attack}" /></span> de ataque.

<div>
		<a href="searchPokemon">Entrar en cueva</a>
	
</div>


</body>
</html>