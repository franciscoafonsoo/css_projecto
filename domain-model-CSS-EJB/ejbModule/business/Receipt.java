package business;

import business.Documents;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Receipt
 *
 */
@Entity
public class Receipt extends Documents{
	
	private double value;
	
	@ManyToOne private Payment paymentPlan;
	
	private int tranche;
	
	private int invoice;
	
	Receipt(){}
	
	public Receipt(double value, int invoice, int tranche, Sale sale) {
		super(sale);
		this.value = value;
		this.tranche = tranche;
		this.invoice = invoice;
	}



	public double getValue() {
		return value;
	}
	
	public int getTranche(){
		return tranche;
	}
	
	public int getInvoiceID() {
		return invoice;
	}
   
}
