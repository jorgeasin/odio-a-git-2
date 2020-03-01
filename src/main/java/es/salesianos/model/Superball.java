package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel2")
public class Superball  extends AbstractBall{
	public Superball() {
		setRate(25);
		setName("Superball");
	}

}
