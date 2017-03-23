package business;

import facade.exceptions.ApplicationException;
import facade.interfaces.ISale;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

/**
 * A sale
 *	
 * @author fmartins
 * @version 1.1 (17/04/2015)
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name=Sale.FIND_BY_CUSTOMER, query = "SELECT s FROM Sale s WHERE s.customer =:" +
				Sale.CUSTOMER),
		@NamedQuery(name=Sale.FIND_ALL_SALES, query = "SELECT s FROM Sale s")
})
public class Sale implements ISale {

	public static final String FIND_BY_CUSTOMER = "Sale.findByCustomer";
	public static final String FIND_ALL_SALES = "Sale.findAll";
	public static final String CUSTOMER = "customer";

	/**
	 * Sale primary key. Needed by JPA. Notice that it is not part of the
	 * original domain model.
	 */
	@Id	@GeneratedValue private int id;
	
	/**
	 * The date the sale was made 
	 */
	@Temporal(TemporalType.DATE) private Date date;

	/**
	 * Whether the sale is open or closed. 
	 */
	@Enumerated(STRING) private SaleStatus status;
	
	@ManyToOne private Customer customer;
	
	/**
	 * The products of the sale
	 */
	@OneToMany(cascade = ALL) @JoinColumn
	private List<SaleProduct> saleProducts;

	private boolean isAnnulled;

	// 1. constructor

	/**
	 * Constructor needed by JPA.
	 */
	protected Sale () {
	}
	
	/**
	 * Creates a new sale given the date it occurred and the customer that
	 * made the purchase.
	 * 
	 * @param date The date that the sale occurred
	 * @param customer The customer that made the purchase
	 */
	public Sale(Date date, Customer customer) {
		this.date = date;
		this.customer = customer;
		this.status = SaleStatus.OPEN;
		this.saleProducts = new LinkedList<SaleProduct>();
	}

	
	// 2. getters and setters

	/**
	 * @return The sale's total 
	 */
	public double total() {
		double total = 0;
		for (SaleProduct sp : saleProducts)
			total += sp.getSubTotal();
		return total;
	}

	/**
	 * @return The sale's amount eligible for discount
	 */
	public double eligibleDiscountTotal () {
		double total = 0;
		for (SaleProduct sp : saleProducts)
			total += sp.getEligibleSubtotal();
		return total;
	}
	
	/**
	 * @return Computes the sale's discount amount based on the discount type of the customer.
	 */
	public double discount () {
		Discount discount = customer.getDiscountType();
		return discount.computeDiscount(this);
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @return Whether the sale is open
	 */
	public boolean isOpen() {
		return status == SaleStatus.OPEN;
	}

	/**
	 * Adds a product to the sale
	 * 
	 * @param product The product to sale
	 * @param qty The amount of the product being sold
	 * @throws ApplicationException 
	 */
	public void addProductToSale(Product product, double qty) 
			throws ApplicationException {
		if (!isOpen())
			throw new ApplicationException("Cannot add products to a closed sale.");

		// if there is enough stock
		if (product.getQty() >= qty) {
			// adds product to sale
			product.setQty(product.getQty() - qty);
			saleProducts.add(new SaleProduct(product, qty));
		} else
			throw new ApplicationException("Product " + product.getProdCod() + " has stock ("  + 
							product.getQty() + ") which is insuficient for the current sale");
	}

	public int getId() {
		return id;
	}

	public List<SaleProduct> getSaleProducts() {
		return saleProducts;
	}

	public boolean getAnnulled () {
		return isAnnulled;
	}

	public void setAnnulled (boolean isAnnulled) {
		this.isAnnulled = isAnnulled;
	}

	public void removeSaleProducts() {
		this.saleProducts = new LinkedList<>();
	}
}
