package business;

import static javax.persistence.TemporalType.DATE;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;



@Entity
public class Invoice extends Documents {
	
	private double totalPrice;
	
	private double taxCharged;
	
	private double totalCharged;
	
	//@OneToMany
	//private List<SaleProduct> items;
	
	public Invoice(){};
	
	
	public Invoice(Sale sale){
		super(sale);
		this.totalPrice = sale.total();
		this.taxCharged = totalPrice * 0.23;
		this.totalCharged = totalPrice + taxCharged;
		
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public double getTaxCharged() {
		return taxCharged;
	}


	public double getValue() {
		return totalCharged;
	}




	//public Iterable<SaleProduct> getItems() {
	//	return items;
	//}
	
}
