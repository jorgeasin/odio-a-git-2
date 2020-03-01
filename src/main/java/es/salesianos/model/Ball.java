package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;

public interface Ball {

	public int getNumber();

	public void setNumber(int i);

	public String getName();

	public void setName(String name);

	public int getRate();

	
}
