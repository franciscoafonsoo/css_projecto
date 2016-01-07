package business;

import java.io.Serializable;

public class InvoiceDTO implements Serializable{
	
	private static final long serialVersionUID = 4232849114219500244L;
	
	private int id;
	
	private double totalPrice;
	
	private double taxCharged;
	
	private double totalCharged;

	public InvoiceDTO(){}
	
	public InvoiceDTO(int id, double totalPrice, double taxCharged, double totalCharged) {
		this.id = id;
		this.totalPrice = totalPrice;
		this.taxCharged = taxCharged;
		this.totalCharged = totalCharged;
	}
	
	public int getId() {
		return id;
	}
	
	public double getTotalPrice () {
		return totalPrice;
	}
	
	public double getTaxCharged () {
		return taxCharged;
	}
	
	public double getTotalCharged () {
		return totalCharged;
	}

}
