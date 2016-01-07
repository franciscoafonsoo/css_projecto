package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PaymentCatalog {

	@PersistenceContext
	private EntityManager em;

	public void newPayment(Invoice inv) throws ApplicationException {
		Customer c = inv.getCustomer();
		Discount d = c.getDiscountType();
		try{
			Payment p;
			if (d instanceof NoDiscount) {
				p = new PartedPayment(c.getVATNumber(), inv);
			}
			else if (d instanceof EligibleProductsDiscount) {
				p = new EligiblePayment(c.getVATNumber(), inv);
			}
			else {
				p = new FullPayment(c.getVATNumber(), inv);
			}
			em.persist(p);
		}
		catch(Exception e){
			throw new ApplicationException("Error in creating payment", e);
		}
	}
	
	public Payment getPayment (int id) throws ApplicationException {
		try{
			TypedQuery<Payment> q = em.createNamedQuery("Payment.findById", Payment.class);
			q.setParameter("id" , id);
			return q.getSingleResult();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting Payment", e);
		}
	}
	
	public Iterable<Payment> getPaymentsByVAT(int vat) throws ApplicationException {
		try{
			TypedQuery<Payment> q = em.createNamedQuery("Payment.findAllByVAT", Payment.class);
			q.setParameter("vat", vat);
			return q.getResultList();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting all Payment", e);
		}
	}
	
	public Payment getPaymentsByInvId(int id) throws ApplicationException {
		try{
			TypedQuery<Payment> q = em.createNamedQuery("Payment.findByInvId", Payment.class);
			q.setParameter("id", id);
			return q.getSingleResult();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting Payment by InvId", e);
		}
		
	}
	public void payInvoice(int invoiceId) throws ApplicationException {
		try{
			Payment payTranche = getPaymentsByInvId(invoiceId);
			payTranche.PayInvoice();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error paying Invoice", e);
		}
	}
	
	public List<Payment> getAllPayments() throws ApplicationException {
		try {
			TypedQuery<Payment> q = em.createNamedQuery("Payment.findAll", Payment.class);
			return q.getResultList();
			
		}
		catch (Exception e) {
			throw new ApplicationException("Something Shady: get all payments", e);
		}
	}
	
}
