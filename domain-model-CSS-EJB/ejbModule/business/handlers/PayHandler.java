package business.handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import business.ApplicationException;
import business.DocumentsCatalog;
import business.Payment;
import business.PaymentCatalog;

@Stateless
public class PayHandler implements PayHandlerRemote{
	
	@EJB private PaymentCatalog paymentCatalog;
	
	@EJB private DocumentsCatalog documentsCatalog;
	
	public void pay(int id) throws ApplicationException {
		Payment p = paymentCatalog.getPayment(id);
		p.PayInvoice();
		documentsCatalog.newReceipt(p.trancheValue(), p.getInvoice(), p.getNextTranche()-1);;
	}
}
