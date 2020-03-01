package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	@Autowired
	private Ball pokeball;
	private List <Ball> pokeballs= new ArrayList<Ball>(); 
	
	private Pokemon pokemon;
	private Pokemon pokeActive;
	
	private List <Pokemon> pokemons= new ArrayList<Pokemon>(); 
	private List <Pokemon> pokemonsCaptured= new ArrayList<Pokemon>(); 
	

	public List<Pokemon> getPokemonsCaptured() {
		return pokemonsCaptured;
	}
	public void setPokemonsCaptured(List<Pokemon> pokemonsCaptured) {
		this.pokemonsCaptured = pokemonsCaptured;
	}
	public void addPokemonsCaptured(Pokemon pokemons) {
		this.pokemonsCaptured.add(pokemons);
	}

	public List <Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(List <Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	
	public void addPokemons(Pokemon pokemons) {
		this.pokemons.add(pokemons);
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public Ball getPokeball() {
		return pokeball;
	}
	public void setPokeball(Ball pokeball) {
		this.pokeball = pokeball;
	}
	public Pokemon getPokeActive() {
		return pokeActive;
	}
	public void setPokeActive(Pokemon pokeActive) {
		this.pokeActive = pokeActive;
	}
	public List <Ball> getPokeballs() {
		return pokeballs;
	}
	public void setPokeballs(List <Ball> pokeballs) {
		this.pokeballs = pokeballs;
	}
	public void addBalls(Ball ball) {
		this.pokeballs.add(ball);
	}
	public void delete(Person person) {
		this.pokeActive= null;
		this.pokemon= null;
		this.pokemons= new ArrayList<Pokemon>();
		this.pokemonsCaptured= new ArrayList<Pokemon>();
		
		
	}
}
