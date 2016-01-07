package business;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Payment
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Payment.findById", query="SELECT p FROM Payment p WHERE p.id = :id"),
	@NamedQuery(name="Payment.findAllByVAT", query="SELECT p FROM Payment p WHERE p.clientVat = :vat"),
	@NamedQuery(name="Payment.findByInvId", query="SELECT p FROM Payment p WHERE p.invID = :id"),
	@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
})

public abstract class Payment {

	
	@Id @GeneratedValue
	private int id;
	
	private int clientVat;
	
	@ManyToOne private Invoice transaction;
	
	private int invID;
	
	private double NotPaydYet;
	
	private double initialValue;
	
	@Temporal(DATE)
	protected Date d;
	
	protected int payd;
	
	
	Payment(){}
	
	public Payment(int vat, Invoice fatura) {
		this.clientVat = vat;
		this.transaction = fatura;
		invID = fatura.getId();
		this.NotPaydYet = transaction.getValue();
		initialValue = NotPaydYet;
		
		 
	}
	
	public abstract void PayInvoice();
	
	public double getMissingPayment() {
		return NotPaydYet;
	}
	
	public void payPrice(double amount) {
		NotPaydYet = NotPaydYet-amount;
	}
	public Invoice getInvoice() {
		return transaction;
	}
	
	public abstract Date getPaymentDay();
	
	
	
	public boolean Payd() {
		return getMissingPayment()==0;
	}
	
	public double getValue() {
		return initialValue;
	}
	
	public abstract double trancheValue();
	public abstract int getNextTranche();
	public abstract boolean isLate();
	

}
