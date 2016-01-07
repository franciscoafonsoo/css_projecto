package business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {

	@Id @GeneratedValue
	private int id;
	
	private String address;
	
	private String name;
	
	public Company(){
		this.id = 1;
		this.address = "Teste empresa 1";
		this.name = "Nome da empresa";
	}
	
	public int getId(){
		return id;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getName(){
		return name;
	}
}
