package es.salesianos.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import es.salesianos.model.Item;

import es.salesianos.model.Person;
import es.salesianos.model.Pokeball;
import es.salesianos.model.Ball;
import es.salesianos.model.Pokemon;
import es.salesianos.model.Superball;
import es.salesianos.model.Ultraball;


@Controller
public class IndexController {

	private static Logger log = LogManager.getLogger(IndexController.class);

	@Autowired
	private Person person;
	@Autowired
	private Person rival;
	

	@GetMapping("/")
	public ModelAndView index() {
		Superball sb = new Superball();
		person.addBalls(sb);
		Pokeball pb = new Pokeball();
		person.addBalls(pb);
		Ultraball ub = new Ultraball();
		person.addBalls(ub);
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("person", this.person);
		modelAndView.addObject("rival", this.rival);

		return modelAndView;
	}

	
	@PostMapping("insert")
	public ModelAndView personInsert(Person personForm) {
		log.debug("personInsert:" + this.person.toString());		
		ModelAndView modelAndView = new ModelAndView("index");
		// this.person=personForm;
		addPageData(personForm);
		modelAndView.addObject("person", person);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}
	
	@PostMapping("insertPokemonFriend")
	public ModelAndView pokemonFirendInsert(Person personForm) {
		ModelAndView modelAndView = new ModelAndView("index");
		System.out.println("agrego al ser aliado");
		if (person.getPokemons().size()<6) {
			person.addPokemons(AgregarPokemon(personForm.getPokemon()));
			if (person.getPokemons().size() == 1) {
				person.setPokeActive(personForm.getPokemon());
			}
		}else
			System.out.println("Tu equipo esta lleno boca chancla");
		modelAndView.addObject("person", person);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}


	
	
	@PostMapping("insertWildPokemon")
	public ModelAndView pokemonWildInsert(Person personForm) {
		ModelAndView modelAndView = new ModelAndView("index");
		System.out.println("agrego al ser salvaje");
		rival.setPokemon(AgregarPokemon(personForm.getPokemon()));
		modelAndView.addObject("person", person);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}
	
	private void addPageData(Person personForm) {
		/*if (!StringUtils.isEmpty(personForm.getName())) {
			person.setName(personForm.getName());
		}
		if (!StringUtils.isEmpty(personForm.getPokeball())) {
			Pokeball pokeball = personForm.getPokeball();
			
			pokeball.setName(personForm.getPokeball().getName());
			pokeball.setNumber(person.getPokeball().getNumber() + personForm.getPokeball().getNumber());	
			System.out.println("metelo");
			this.person.setPokeball(pokeball);
			
		}
		*/
	}
	
	@PostMapping("switchPokemon")
	public ModelAndView switchPokemon() {
		
		if (this.person.getPokemons().size()>1) {
			Pokemon tmp;
			tmp = this.person.getPokemons().get(0);
			this.person.getPokemons().remove(0);
			this.person.getPokemons().add(tmp);
			person.setPokeActive(person.getPokemons().get(0));
		}
		else {
			System.out.println("pero tu eres tonto o que te pasa si solo tienes un pokemone a que coño vas a cambiar");
		}
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("person", this.person);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}
	@PostMapping("switchPokemonCave")
	public ModelAndView switchPokemonCave() {
		
		if (this.person.getPokemons().size()>1) {
			Pokemon tmp;
			tmp = this.person.getPokemons().get(0);
			this.person.getPokemons().remove(0);
			this.person.getPokemons().add(tmp);
			person.setPokeActive(person.getPokemons().get(0));
		}
		else {
			System.out.println("pero tu eres tonto o que te pasa si solo tienes un pokemone a que coño vas a cambiar");
		}
		ModelAndView modelAndView = new ModelAndView("cave");
		modelAndView.addObject("person", this.person);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}

	@GetMapping("searchPokemon")
	public ModelAndView searchPokemon() {
		ModelAndView modelAndView;
		if (person.getPokeActive()== null || rival.getPokemon() == null ) {
			System.out.println("adonde vas hijo mio sin rival o sin pokemon");
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("person", this.person);
			modelAndView.addObject("rival", this.rival);
		}
		else
		{
			modelAndView = new ModelAndView("cave");
			modelAndView.addObject("person", this.person);
			modelAndView.addObject("rival", this.rival);
		}
		return modelAndView;
	}
	@PostMapping("kidnap")
	public ModelAndView KidnapPoorPokemon(Person personForm) {
		ModelAndView modelAndView;
		
		if (notDeath(person.getPokeActive()) && lifeCounter() && kidnaped()) {
			this.person.addPokemonsCaptured(rival.getPokemon());
			
			System.out.println("secuestro completo");
			rival.setPokemon(null);
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("person", this.person);
			modelAndView.addObject("rival", rival);
			return modelAndView;
			
		}
		modelAndView = new ModelAndView("cave");
		modelAndView.addObject("person", this.person);
		modelAndView.addObject("rival", this.rival);
		return modelAndView;
	}
	

	@GetMapping("PokemonFight")
	public ModelAndView Fight() {
		if (notDeath(person.getPokeActive())) {
			
			this.rival.getPokemon().setHp(getDamage(this.person.getPokeActive(),this.rival.getPokemon() ));
			if (notDeath(rival.getPokemon()) && notDeath(person.getPokeActive())) {
				this.person.getPokeActive().setHp(getDamage(this.rival.getPokemon(), this.person.getPokeActive() ));
			}
			else {
				System.out.println("lo mataste wei");
				rival.setPokemon(null);
				ModelAndView modelAndView = new ModelAndView("index");
				modelAndView.addObject("person", this.person);
				modelAndView.addObject("rival", this.rival);
				return modelAndView;
			}
		}
		
		
		ModelAndView modelAndView = new ModelAndView("cave");
		modelAndView.addObject("person", this.person);
		modelAndView.addObject("rival", this.rival);
		return modelAndView;
	}


	private int getDamage(Pokemon poke1, Pokemon poke2) {
		double damage;
		
		damage = poke2.getHp() - poke1.getAttack() * Math.random();
		int damageRounded = (int) Math.round(damage);
		
		
		return damageRounded;
	}


	private boolean lifeCounter() {
		System.out.println(rival.getPokemon().getHp()  *100/ rival.getPokemon().getMaxHp());
		if (rival.getPokemon().getHp()  *100/ rival.getPokemon().getMaxHp()<25)
			return true;
		else
			return false;
		
	}


	private boolean kidnaped() {
		System.out.println(person.getPokeball().getRate());
		
		if (person.getPokeball().getRate()>= (Math.random())*100) {
			return true;
		}
		else
			return false;
	}
	
	private boolean notDeath(Pokemon poke) {
		if (poke.getHp()>0)
			return true;
		else
			return false;
		
	}


	private Pokemon AgregarPokemon(Pokemon personForm) {
		Pokemon pokemon =  new Pokemon();
		//pokemon = personForm.getPokemon(); esto va que te cagas
		pokemon.setName(personForm.getName());
		pokemon.setHp(personForm.getHp());
		pokemon.setMaxHp(personForm.getHp());
		pokemon.setAttack(personForm.getAttack());
		
		return pokemon;
	}
}
