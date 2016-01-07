package business.handlers;

import javax.ejb.Remote;

import business.ApplicationException;

@Remote
public interface ProcessSaleHandlerRemote {

	void newSale(int vatNumber) throws ApplicationException;
	
	void addProductToSale(int saleId, int prodId, int quant) throws ApplicationException;

	void createInvoice(int saleId) throws ApplicationException;
	
	void closeSale(int saleId) throws ApplicationException;
}
