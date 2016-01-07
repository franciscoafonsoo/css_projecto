package business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: EligiblePayment
 *
 */
@Entity

public class EligiblePayment extends Payment {

	
	
	

	EligiblePayment(){}
	
	public EligiblePayment(int vatnumber, Invoice fatura) {
		super(vatnumber, fatura);
		d = new Date();
		d.setMonth(d.getMonth()+1%12);
		payd = 0;
	}

	@Override
	public void PayInvoice() {
		this.payPrice(this.getMissingPayment());
		payd = 1;
	}
	

	
	public double trancheValue() {
		return getInvoice().getValue();
	}
	

	public int getNextTranche() {return 1;}

	@Override
	public Date getPaymentDay() {
		return d;
	}
	
	public boolean isLate() {
		Date current = new Date();
		return current.after(getPaymentDay());
	}
}
