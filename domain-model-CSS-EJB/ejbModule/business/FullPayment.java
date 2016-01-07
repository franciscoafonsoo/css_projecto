package business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FullPayment
 *
 */
@Entity

public class FullPayment extends Payment{
	
	FullPayment(){}

	public FullPayment(int vatnumber, Invoice fatura) {
		super(vatnumber, fatura);
		payd = 0;
	}

	@Override
	public void PayInvoice() {
		this.payPrice(this.getMissingPayment());
		payd=1;
		
	}
	
	public double trancheValue() {
		return getInvoice().getValue();
	}
	
	public int getNextTranche() {return 1;}

	@Override
	public Date getPaymentDay() {
		return new Date();
	}
	
	public boolean isLate() {
		return false;
	}
	
	
   
}
