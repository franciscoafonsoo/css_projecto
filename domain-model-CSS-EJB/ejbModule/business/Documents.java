package business;

import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="Documents.findById", query="SELECT d FROM Documents d WHERE d.id = :id"),
	@NamedQuery(name="Documents.findAll", query="SELECT d FROM Documents d"),
	@NamedQuery(name="Documents.findByVAT", query="SELECT d FROM Documents d WHERE d.customerVat = :vat")
})
public abstract class Documents {
	
	@Id @GeneratedValue
	private int id;
	
	private int saleNum;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String companyAdress;
	
	private int companyNumber;

	private int customerVat;
	
	private String customerName;
	
	@ManyToOne private Sale sale;
	
	public Documents(){};
	
	public Documents(Sale sale){
		Company localCompany = new Company();
		this.sale = sale;
		this.saleNum = sale.getId();
		this.date = new Date();
		this.companyAdress = localCompany.getAddress();
		this.companyNumber = localCompany.getId();
		this.customerVat = sale.getCustomer().getVATNumber();
		this.customerName = sale.getCustomer().getDesignation();
	}

	public int getId() {
		return id;
	}
	
	public Sale getSale(){
		return sale;
	}

	public int getSaleNum() {
		return saleNum;
	}

	public Date getDate() {
		return date;
	}

	public String getCompanyAdress() {
		return companyAdress;
	}

	public int getCompanyNumber() {
		return companyNumber;
	}

	public int getCustomerVat() {
		return customerVat;
	}

	public String getCustomerName() {
		return customerName;
	}
	
	public Customer getCustomer() {
		return sale.getCustomer();
	}
	
	public abstract double getValue();


	
}
