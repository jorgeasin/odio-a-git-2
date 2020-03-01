package es.salesianos.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBall implements Ball {
	
	private int number;
	private String name;
	private int rate;
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getNumber() {
		return number;
	}
	@Override
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}

	
	
	
}
