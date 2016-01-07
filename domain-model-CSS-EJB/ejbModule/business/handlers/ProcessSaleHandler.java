package business.handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import business.ApplicationException;
import business.Customer;
import business.CustomerCatalog;
import business.Product;
import business.ProductCatalog;
import business.Sale;
import business.SaleCatalog;
import business.DocumentsCatalog;
import business.Invoice;
import business.PaymentCatalog;


/**
 * Handles client's transactions. 
 * Each public method implements a transaction script.
 * 
 * @author fmartins
 *
 */

@Stateless
public class ProcessSaleHandler implements ProcessSaleHandlerRemote {
	
	/**
	 * The sale's catalog
	 */
	@EJB private SaleCatalog saleCatalog;

	/**
	 * The customer's catalog
	 */
	@EJB private CustomerCatalog customerCatalog;
	
	/**
	 * The product's catalog
	 */
	@EJB private ProductCatalog productCatalog;
	
	/**
	 * The document's catalog
	 */

	@EJB private DocumentsCatalog documentCatalog;
	
	@EJB private PaymentCatalog paymentCatalog;
	

	/**
	 * Creates a new sale
	 * 
	 * @param vatNumber The customer's VAT number for the sale
	 * @throws ApplicationException In case the customer is not in the repository
	 */
	public void newSale (int vatNumber) throws ApplicationException {
		Customer customer = customerCatalog.getCustomer(vatNumber);
		saleCatalog.newSale(customer);
		
	}

	/**
	 * Adds a product to the current sale
	 * 
	 * @param prodCod The product code to be added to the sale 
	 * @param qty The quantity of the product sold
	 * @throws ApplicationException When the sale is closed, the product code
	 * is not part of the product's catalog, or when there is not enough stock
	 * to proceed with the sale
	 */
	public void addProductToSale (int saleId, int prodCod, int qty ) throws ApplicationException {
		Product product = productCatalog.getProduct(prodCod);			
		saleCatalog.addProductToSale(saleCatalog.getSale(saleId), product, qty);
	}

	/**
	 * @return The sale's discount, according to the customer discount type
	 * @throws ApplicationException When some persistence error occurs
	 */
	public double getSaleDiscount () throws ApplicationException  {
		return (Double) null;
	}

	@Override
	public void createInvoice(int saleId) throws ApplicationException {
		Sale s = saleCatalog.getSale(saleId);
		Invoice i = documentCatalog.newInvoice(s);
		paymentCatalog.newPayment(i);
	}
	
	public void closeSale(int saleId) throws ApplicationException {
		Sale s = saleCatalog.getSale(saleId);
		s.close();
	}
}
