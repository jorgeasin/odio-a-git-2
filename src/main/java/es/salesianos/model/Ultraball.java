package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel3")
public class Ultraball extends AbstractBall{

	public Ultraball() {
		setRate(50);
		setName("Ultraball");
	}
}
