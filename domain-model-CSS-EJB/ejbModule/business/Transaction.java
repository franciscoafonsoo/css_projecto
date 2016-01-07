package business;

import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Transaction
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Transaction.findById", query="SELECT t FROM Transaction t WHERE t.id = :id"),
	@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t"),
	@NamedQuery(name="Transaction.findAllByVAT", query="SELECT t FROM Transaction t WHERE t.customerVat = :vat")
})

public class Transaction {

	
	

	@Id @GeneratedValue
	private int id;

	//private TransactionType type;
	
	private double value;
	
	private int docID;
	
	private int customerVat;
	
	@Temporal(DATE)
	private Date d;
	
	Transaction(){}
	
	public Transaction(TransactionType type, double value, int docID, int customerVat) {
		//this.type = type;
		this.value = value;
		this.docID = docID;
		this.customerVat = customerVat;
		this.d = new Date();
		
	}
	
//	public TransactionType getType() {
//		return type;
//	}
	
	public double getValue() {
		return value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

//	public void setType(TransactionType type) {
//		this.type = type;
//	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public Date getDate() {
		return d;
	}
   
}
