<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="kidnap" method="post" modelAttribute="person">
<table border="1">
		<thead>
			<tr>
				<td>Pokeball</td>
				<td>Accion</td>
			</tr>
		</thead>
		<tbody>
		
				<tr>
					<td><c:out value="${person.pokeball.name}" /></td>
					
					
					<td><input type="submit" value="Secuestrar " /></td>
				</tr>
			
				
		</tbody>
	</table>
</form:form>
	<br />
	<br />
	<br />
	<span><c:out value="Pokemon Aliado" /></span>
	<table border="1">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>hp</td>
				<td>ataque</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${person.pokeActive.name}" /></td>
					<td><c:out value="${person.pokeActive.hp}" /></td>
					<td><c:out value="${person.pokeActive.attack}" /></td>
				</tr>
		
		</tbody>
	</table>
	<br />
	<br />
	<br />
	<span><c:out value="Pokemon Salvaje" /></span>
	<table border="1" align="left">
		<thead>
			<tr>
				<td>pokemon</td>
				<td>hp</td>
				<td>ataque</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${rival.pokemon.name}" /></td>
					<td><c:out value="${rival.pokemon.hp}" /></td>
					<td><c:out value="${rival.pokemon.attack}" /></td>
				</tr>
		</tbody>
	</table>
	<br />
	<br />
	<form:form action="switchPokemonCave" method="post">
		<input type="submit" value="cambiar de esclavo" />
	</form:form>
	<br />
	<div>
		<a href="PokemonFight">Luchar</a>
	
</div>
</body>
</html>