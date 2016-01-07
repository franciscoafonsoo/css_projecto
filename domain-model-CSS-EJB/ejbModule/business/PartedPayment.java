package business;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: PartedPayment
 *
 */
@Entity

public class PartedPayment extends Payment{
	
	@Temporal(DATE)
	private Date firstPayment;
	private boolean firstPayd = false;
	@Temporal(DATE)
	private Date lastPayment;
	private boolean lastPayd = false;
	
	PartedPayment(){}

	public PartedPayment(int vatnumber, Invoice fatura) {
		super(vatnumber, fatura);
		firstPayment = new Date();
		firstPayment.setMonth(firstPayment.getMonth()+1%12);
		lastPayment = new Date();
		lastPayment.setMonth(lastPayment.getMonth()+2%12);
		payd = 0;
	}

	@Override
	public void PayInvoice() {
		if (!firstPayd) {
			PayPart(this.getMissingPayment()/2);
		}
		else {
			PayPart(this.getMissingPayment());
		}
	}
	
	public void PayPart(double amount) {
		payPrice(amount);
		if (getMissingPayment()>0){
			firstPayd = true;
		}
		if (getMissingPayment() == 0){
			lastPayd = true;
			payd = 1;
		}
	}
	
	public Date getNextPayDate() {
		if (!firstPayd) {
			return firstPayment;
		}
		else {
			return lastPayment;
		}
	}
	
	public int getNextTranche() {
		if (!firstPayd) {
			return 1;
		}
		else if (!lastPayd) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	public double trancheValue() {
		return getInvoice().getValue()/2;
	}

	@Override
	public Date getPaymentDay() {
		return getNextPayDate();
	}
	
	public boolean isLate() {
		Date current = new Date();
		if (firstPayd) {
			if (lastPayd) {
				return false;
			}
			else {
				return current.after(lastPayment);
			}
		}
		else {
			return current.after(lastPayment);
		}
	}
	
}
